package com.warriors.model;

public class Warrior {
    private static final int ATTACK = 5;
    private static final int INITIAL_HEALTH = 50;
    private int health = INITIAL_HEALTH;
    public boolean isAlive() {
        return health > 0;
    }

    public void hit(Warrior opponent) {
        opponent.health -= getAttack();
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return ATTACK;
    }
}
