package decorator;

public class SimpleTroll implements Troll{
    @Override
    public void attack() {
        System.out.println("SimpleTroll try to attack you ");
    }

    @Override
    public int getAttackPower() {
        return 10;
    }

    @Override
    public void fleeBattle() {
        System.out.println("SimpleTroll run away...");
    }
}
