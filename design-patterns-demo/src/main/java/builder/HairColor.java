package builder;

public enum HairColor {

    WHITE, RED, BLACK,

    ;


    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
