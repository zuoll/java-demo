package callback;

import java.util.Optional;

/**
 * 作为一个模板方法执行回调
 */
public abstract class Task {

    public void executeWith(Callback callback){
        this.execute();

        //在执行回调
        Optional.ofNullable(callback).ifPresent(Callback::call);
    }


    public  abstract void execute();
}
