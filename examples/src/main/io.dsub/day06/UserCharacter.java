package io.dsub.day06;

public class UserCharacter {
    private int hp;
    private int damage;
    private float atkRange;
    private String name;

    // constructors
    public UserCharacter(int hp, int damage, float atkRange, String name) {
        this.hp = hp;
        this.damage = damage;
        this.atkRange = atkRange;
        this.name = name;
    }

    public UserCharacter(String name) {
        this(50, 1, 1.0f, name);
    }

    // getters and setters
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp > 1 && hp < Integer.MAX_VALUE)
            this.hp = hp;
        else
            System.out.printf("invalid input %d (range: 1 <= hp < %d)\n", hp, Integer.MAX_VALUE);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public float getAtkRange() {
        return atkRange;
    }

    public void setAtkRange(float atkRange) {
        this.atkRange = atkRange;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
