package com.warriors.model.warriors;

import com.warriors.model.warriors.interfaces.Fightable;
import com.warriors.model.warriors.interfaces.Vampirism;

public class Vampire extends Warrior implements Vampirism {
    public static final int INITIAL_ATTACK = 4;
    public static final int INITIAL_HEALTH = 40;
    public static final int INITIAL_VAMPIRISM = 50;

    public Vampire() {
        super(INITIAL_HEALTH, INITIAL_ATTACK);
    }

    @Override
    public void hit(Fightable opponent) {
        super.hit(opponent);
        drainLife(opponent);
    }

    @Override
    public int getVampirism() {
        return INITIAL_VAMPIRISM;
    }

    @Override
    public void drainLife(Fightable opponent) {
        int drainedLife = (opponent.getReceivedDamage() * getVampirism()) / 100;
        this.setHealth(Math.min(INITIAL_HEALTH, this.getHealth() + drainedLife));
    }
}
