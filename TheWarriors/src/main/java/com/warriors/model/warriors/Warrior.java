package com.warriors.model.warriors;

import com.warriors.model.damage.IDamage;
import com.warriors.model.damage.SimpleDamage;
import com.warriors.model.warriors.interfaces.IWarrior;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Warrior implements IWarrior {
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
    public void hit(IWarrior opponent) {
        opponent.receiveDamage(new SimpleDamage(getAttack(), this));
    }

    @Override
    public void receiveDamage(IDamage damage) {
        setHealth(getHealth() - damage.hitPoints());
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public int getHealth() {
        LOGGER.trace("{} has {} points of health.", this, health);
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
