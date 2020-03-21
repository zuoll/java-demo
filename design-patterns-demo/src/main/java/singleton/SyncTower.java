package singleton;

public class SyncTower {

    private static SyncTower instance;

    private SyncTower() {
        if (instance == null) {
            instance = this;
        } else {
            throw new IllegalArgumentException("already instance");
        }
    }

    public static synchronized SyncTower getInstance() {
        if (instance == null) {
            instance = new SyncTower();
        }
        return instance;
    }

}
