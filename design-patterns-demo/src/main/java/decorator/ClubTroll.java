package decorator;

/**
 * 俱乐部的巨魔(人工养的)
 */
public class ClubTroll implements Troll {

    private Troll decorated;

    public ClubTroll(Troll decorated) {
        this.decorated = decorated;
    }


    @Override
    public void attack() {
        decorated.attack();

        System.out.println("the troll can swing with a club");
    }

    @Override
    public int getAttackPower() {
        return decorated.getAttackPower() + 10;
    }

    @Override
    public void fleeBattle() {
        decorated.fleeBattle();
    }
}
