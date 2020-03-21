package singleton;

/**
 * 饿汉式
 */
public final  class IvoryTower {

    private IvoryTower(){}

    //static class
    private static final IvoryTower instance =  new IvoryTower();

    public static IvoryTower getInstance(){
        return instance;
    }
}
