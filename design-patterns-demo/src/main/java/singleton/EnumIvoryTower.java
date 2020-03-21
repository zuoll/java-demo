package singleton;

/**
 * 枚举是线程安全的
 */
public enum EnumIvoryTower {

    INSTANCE;


    @Override
    public String toString() {
        return getDeclaringClass().getCanonicalName()+"@"+hashCode();
    }
}
