package com.warriors.model.warriors;

public class Vampire extends Warrior {
    public static final int INITIAL_ATTACK = 4;
    public static final int INITIAL_HEALTH = 40;
    public static final int INITIAL_VAMPIRISM = 50;
    private final int vampirism;

    public Vampire() {
        super(INITIAL_HEALTH, INITIAL_ATTACK);
        vampirism = INITIAL_VAMPIRISM;
    }
}
