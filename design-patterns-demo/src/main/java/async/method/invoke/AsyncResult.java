package async.method.invoke;

import java.util.concurrent.ExecutionException;

/**
 *
 * @param <T> parameter returned when getValue is invoked
 */
public interface AsyncResult<T> {

    /**
     * status of async task execution
     * @return
     */
    boolean isCompleted();


    /**
     * gets the values of  completes async task
     * @return
     * @throws ExecutionException
     */
    T getValue() throws ExecutionException;


    /**
     * block the current thread until the async task is complete
     * @throws InterruptedException
     */
    void await() throws InterruptedException;
}
