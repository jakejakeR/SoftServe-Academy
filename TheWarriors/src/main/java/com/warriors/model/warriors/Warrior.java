package com.warriors.model.warriors;

import com.warriors.model.damage.Damage;
import com.warriors.model.damage.SimpleDamage;

public class Warrior implements Cloneable, Fightable {
    public static final int INITIAL_ATTACK = 5;
    public static final int INITIAL_HEALTH = 50;
    private int health;
    private int attack;

    public Warrior() {
        this(INITIAL_HEALTH, INITIAL_ATTACK);
    }

    protected Warrior(int health, int attack) {
        this.health = health;
        this.attack = attack;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public void hit(Fightable opponent) {
        opponent.receiveDamage(new SimpleDamage(getAttack()), this);
    }

    @Override
    public void receiveDamage(Damage damage, Fightable damageDealer) {
        setHealth(getHealth() - damage.getHitPoints());
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

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
