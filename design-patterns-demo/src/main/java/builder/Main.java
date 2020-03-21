package builder;

public class Main {

    public static void main(String[] args) {

        Hero hero = new Hero.Builder("zs", Profession.WARRIOR)
                .withHairColor(HairColor.BLACK)
                .withHairType(HairType.LONG)
                .withWeapon(Weapon.BOW)
                .build();

        System.out.println(hero);
    }
}
