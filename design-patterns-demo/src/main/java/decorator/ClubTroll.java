package decorator;

/**
 * 俱乐部的巨魔(人工养的)
 */
public class ClubTroll implements Troll {

    private Troll decoratoed;

    public ClubTroll(Troll decoratoed) {
        this.decoratoed = decoratoed;
    }


    @Override
    public void attack() {
        decoratoed.attack();

        System.out.println("the troll can swing with a club");
    }

    @Override
    public int getAttackPower() {
        return decoratoed.getAttackPower() + 10;
    }

    @Override
    public void fleeBattle() {
        decoratoed.fleeBattle();
    }
}
