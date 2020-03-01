package decorator;

/**
 * 定义一个巨魔的接口
 */
public interface Troll {

    /**
     * 攻击
     */
    void attack();


    /**
     * 获取攻击力量
     * @return
     */
    int getAttackPower();


    /**
     * 逃离战场
     */
    void fleeBattle();
}
