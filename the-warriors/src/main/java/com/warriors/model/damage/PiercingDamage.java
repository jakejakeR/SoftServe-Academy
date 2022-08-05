package com.warriors.model.damage;

import com.warriors.model.warriors.interfaces.IWarrior;

public class PiercingDamage extends SimpleDamage {

    private int counter = 2;

    public PiercingDamage(int hitPoints, IWarrior damageDealer) {
        super(hitPoints, damageDealer);
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
