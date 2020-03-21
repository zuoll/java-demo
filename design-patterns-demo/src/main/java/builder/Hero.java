package builder;

public class Hero {

    private final String name;
    private final Profession profession;
    private final HairColor hairColor;
    private final HairType hairType;
    private final Weapon weapon;

    private Hero(Builder builder) {
        this.name = builder.name;
        this.profession = builder.profession;
        this.hairColor = builder.hairColor;
        this.hairType = builder.hairType;
        this.weapon = builder.weapon;
    }

    public String getName() {
        return name;
    }

    public Profession getProfession() {
        return profession;
    }

    public HairColor getHairColor() {
        return hairColor;
    }

    public HairType getHairType() {
        return hairType;
    }

    public Weapon getWeapon() {
        return weapon;
    }


    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", profession=" + profession +
                ", hairColor=" + hairColor +
                ", hairType=" + hairType +
                ", weapon=" + weapon +
                '}';
    }

    public static class Builder {
        private final String name;
        private final Profession profession;
        private HairColor hairColor;
        private HairType hairType;
        private Weapon weapon;

        public Builder(String name, Profession profession) {
            if (profession == null || name == null) {
                throw new IllegalArgumentException("profession or name  is not null");
            }

            this.name = name;
            this.profession = profession;
        }

        public Builder withHairType(HairType hairType) {
            this.hairType = hairType;
            return this;
        }

        public Builder withHairColor(HairColor hairColor) {
            this.hairColor = hairColor;
            return this;
        }

        public Builder withWeapon(Weapon weapon) {
            this.weapon = weapon;
            return this;
        }
        public Hero build() {
            return new Hero(this);
        }
    }
}
