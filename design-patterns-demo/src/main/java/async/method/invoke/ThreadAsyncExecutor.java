package async.method.invoke;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 异步执行器
 */
public class ThreadAsyncExecutor implements AsyncExecutor {

    private final AtomicInteger idx = new AtomicInteger(0);

    @Override
    public <T> AsyncResult<T> startProcess(Callable<T> task) {
        return this.startProcess(task, null);
    }

    @Override
    public <T> AsyncResult<T> startProcess(Callable<T> task, AsyncCallback<T> callback) {

        String threadName = "executor-" + idx.incrementAndGet();
        CompletableResult<T> completableResult = new CompletableResult<>(callback);

        new Thread(() -> {
            try {
                completableResult.setValue(task.call());
            } catch (Exception ex) {
                completableResult.setException(ex);
            }


        }, threadName).start();

        return completableResult;
    }

    @Override
    public <T> T endProcess(AsyncResult<T> asyncCallback) throws InterruptedException, ExecutionException {
        if (!asyncCallback.isCompleted()) {
            asyncCallback.await();
        }

        return asyncCallback.getValue();
    }


    /**
     * @see java.util.concurrent.CompletableFuture
     * @param <T>
     */
    private static class CompletableResult<T> implements AsyncResult<T> {

        static final int RUNNING = 1;
        static final int FAILED = 2;
        static final int COMPLETED = 3;

        final Object lock;
        //避免空指针
        final Optional<AsyncCallback<T>> callback;

        //多线程的可见性保证
        volatile int state = RUNNING;
        T value;
        Exception exception;

        CompletableResult(AsyncCallback<T> callback) {
            this.lock = new Object();
            this.callback = Optional.ofNullable(callback);
        }

        /**
         * sets the values from successful execution and executors callback if available
         * notify other thread waiting for completion
         *
         * @param value
         */
        void setValue(T value) {
            this.value = value;
            this.state = COMPLETED;
            this.callback.ifPresent(ac -> ac.onComplete(value, Optional.<Exception>empty()));

            synchronized (lock) {
                lock.notifyAll();
            }
        }


        void setException(Exception exception) {
            this.exception = exception;
            this.state = FAILED;
            this.callback.ifPresent(ac -> ac.onComplete(null, Optional.of(exception)));
            synchronized (lock) {
                lock.notifyAll();
            }
        }


        @Override
        public boolean isCompleted() {
            return state > RUNNING;
        }

        @Override
        public T getValue() throws ExecutionException {
            if (state == COMPLETED) {
                return value;
            } else if (state == FAILED) {
                throw new ExecutionException(exception);
            } else {
                throw new IllegalArgumentException("execution not completed yet");
            }
        }

        @Override
        public void await() throws InterruptedException {
            synchronized (lock) {
                System.out.println(LocalDateTime.now());
                while (!isCompleted()) {
                    lock.wait();
                }
            }
        }
    }
}
