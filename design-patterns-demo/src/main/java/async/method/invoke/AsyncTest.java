package async.method.invoke;


import java.util.concurrent.Callable;

/**
 * @see AsyncResult
 * @see AsyncCallback
 * @see AsyncExecutor
 *
 * @see java.util.concurrent.FutureTask
 * @see java.util.concurrent.CompletableFuture
 * @see java.util.concurrent.ExecutorService
 */
public class AsyncTest {

    public static void main(String[] args) throws Exception {

        ThreadAsyncExecutor executor = new ThreadAsyncExecutor();

        AsyncResult<Integer> asyncResult = executor.startProcess(lazyval(10, 500));

//        AsyncResult<String> asyncResult1 = executor.startProcess(lazyval("test", 300));
//
//        AsyncResult<Integer> asyncResult2 = executor.startProcess(lazyval(20, 100),
//                callback("callback asyncResult2"));
//        AsyncResult<Integer> asyncResult3 = executor.startProcess(lazyval(20, 100),
//                callback("callback asyncResult3"));
//
//        Thread.sleep(500);
//        System.out.println("do other work");
//
        Integer ret1 = executor.endProcess(asyncResult);
//        String ret2 = executor.endProcess(asyncResult1);
//        Integer ret3 = executor.endProcess(asyncResult2);
//        Integer ret4 = executor.endProcess(asyncResult3);

        asyncResult.await();

//        asyncResult1.await();
//        asyncResult2.await();


        System.out.println(ret1);
//        System.out.println(ret2);
//        System.out.println(ret3);
//        System.out.println(ret4);


    }


    private static <T> Callable<T> lazyval(T val, long delayMills){
        return ()->{
            Thread.sleep(delayMills);
            System.out.println("task complete with "+val);
            return val;
        };
    }


    private static <T> AsyncCallback<T> callback(String name){
        //接口的匿名实现
        return (val, ex)->{
            if(ex.isPresent()){
                System.out.println(name + " is fail,"+ex.get());
            }else{
                System.out.println(name + " ok " +val);
            }
        };
    }
}
