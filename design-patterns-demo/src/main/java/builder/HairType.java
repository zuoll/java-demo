package builder;

import java.util.Arrays;

public enum HairType {

    LONG("long hair"),
    SHORT("short hair"),
    CURLY("curly hair"),
    ;

    private final String title;

    HairType(String title){
        this.title = title;
    }


    @Override
    public String toString() {
        return title;
    }


    public static void main(String[] args) {
        HairType[] values = HairType.values();
        System.out.println(Arrays.toString(values));

        String key = HairType.LONG.name();
        String val = HairType.LONG.toString();

        System.out.println(key);
        System.out.println(val);
    }
}
