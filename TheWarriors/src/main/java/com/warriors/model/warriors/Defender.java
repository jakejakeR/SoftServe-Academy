package com.warriors.model.warriors;

public class Defender extends Warrior implements Defendable {
    private static final int INITIAL_DEFENSE = 2;
    private final int defense;

    public Defender() {
        super(INITIAL_HEALTH, INITIAL_ATTACK);
        this.defense = INITIAL_DEFENSE;
    }

    @Override
    public void defend() {

    }

    public int getDefense() {
        return defense;
    }
}
