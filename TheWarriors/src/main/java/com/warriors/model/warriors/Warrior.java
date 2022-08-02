package com.warriors.model.warriors;

import com.warriors.model.warriors.interfaces.Fightable;

public class Warrior implements Cloneable, Fightable {
    public static final int INITIAL_ATTACK = 5;
    public static final int INITIAL_HEALTH = 50;
    private int health;
    private int attack;
    private int receivedDamage;

    public Warrior() {
        this(INITIAL_HEALTH, INITIAL_ATTACK);
    }

    protected Warrior(int health, int attack) {
        this.health = health;
        this.attack = attack;
    }

    @Override
    public Warrior clone() {
        try {
            return (Warrior) super.clone();
        } catch (CloneNotSupportedException ignored) {
            System.out.println("This message will never be printed");
        }
        return null;
    }

    @Override
    public void reduceHealthBasedOnDamage(int damage) {
        setHealth(getHealth() - damage);
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setReceivedDamage(int damage) {
        receivedDamage = damage;
    }

    @Override
    public int getReceivedDamage() {
        return receivedDamage;
    }

    protected void setHealth(int health) {
        this.health = health;
    }


}
