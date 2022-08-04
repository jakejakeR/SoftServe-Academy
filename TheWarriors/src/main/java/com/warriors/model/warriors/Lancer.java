package com.warriors.model.warriors;

import com.warriors.model.warriors.interfaces.IWarrior;
import com.warriors.model.warriors.interfaces.LongWeapon;

public class Lancer extends Warrior implements LongWeapon {
    public static final int INITIAL_ATTACK = 6;
    private int attack;

    public Lancer() {
        super(INITIAL_HEALTH, INITIAL_ATTACK);
        this.attack = INITIAL_ATTACK;
    }

    @Override
    public void hit(IWarrior opponent) {
    }
}
