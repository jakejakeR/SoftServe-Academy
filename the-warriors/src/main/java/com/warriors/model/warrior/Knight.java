package com.warriors.model.warrior;

public class Knight extends Warrior {
    public static final int INITIAL_ATTACK = 7;

    public Knight() {
        super(INITIAL_HEALTH, INITIAL_ATTACK);
    }

    @Override
    public int getInitialHealth() {
        return INITIAL_HEALTH + equipment.getHealthModifiers();
    }
}
