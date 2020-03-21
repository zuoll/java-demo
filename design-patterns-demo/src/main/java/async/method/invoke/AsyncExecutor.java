package async.method.invoke;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public interface AsyncExecutor {


    /**
     * task processing of an async task, returns immediately with async result
     * @param task
     * @param <T>
     * @return
     */
    <T> AsyncResult<T> startProcess(Callable<T> task);


    /**
     * when task complete execute callback
     * @param task
     * @param callback
     * @param <T>
     * @return
     */
    <T> AsyncResult<T> startProcess(Callable<T> task, AsyncCallback<T> callback);


    /**
     * end process of async task, block the current thread
     * if necessary and returns the evaluate value
     * of the completed task
     * @param asyncResult
     * @param <T>
     * @return
     */
    <T> T endProcess(AsyncResult<T> asyncResult) throws InterruptedException, ExecutionException;
}
