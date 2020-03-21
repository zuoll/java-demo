package singleton;

/**
 * 静态内部类
 */
public class InitialzingHolder {


    private InitialzingHolder() {
    }


    public static InitialzingHolder getInstance(){
        return HolderHelper.instance;
    }

    //provider lazy instance
    private static class HolderHelper{
        private static final InitialzingHolder instance = new  InitialzingHolder();
    }
}
