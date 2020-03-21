package singleton;

public class DoubleCheck {

    private static volatile DoubleCheck instance;

    private static boolean flag = true;


    //prevent reflect instance
    private DoubleCheck() {
        if (flag) {
            flag = false;
        } else {
            throw new IllegalArgumentException("already instance");
        }
    }

    public static DoubleCheck getInstance(){
        DoubleCheck result = instance;
        if(result == null){
            synchronized (DoubleCheck.class){
                //再次赋值
                result  = instance;
                if(result == null){
                    instance = result = new DoubleCheck();
                }
            }
        }
        return result;
    }

}
