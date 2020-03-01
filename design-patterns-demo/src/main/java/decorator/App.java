package decorator;

public class App {
    public static void main(String[] args) {

        //simple
        Troll troll = new SimpleTroll();
        troll.attack();
        troll.fleeBattle();
        System.out.println(troll.getAttackPower());

        //simple enhance

        ClubTroll clubTroll = new ClubTroll(troll);
        clubTroll.attack();
        clubTroll.fleeBattle();//这个没有加强
        System.out.println(clubTroll.getAttackPower());
    }
}
