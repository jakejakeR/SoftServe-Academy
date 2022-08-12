package com.warriors.model.damage;

import com.warriors.model.warrior.interfaces.CanPierce;
import com.warriors.model.warrior.interfaces.IWarrior;

public class PiercingDamage extends SimpleDamage implements IPiercing, CanPierce {

    private int counter = 2;
    private int piercePower;

    public PiercingDamage(int hitPoints, IWarrior damageDealer, int piercePower) {
        super(hitPoints, damageDealer);
        this.piercePower = piercePower;
    }


    @Override
    public void decreaseCounter() {
        counter -= 1;
    }

    @Override
    public int getCounter() {
        return counter;
    }

    @Override
    public void setPierceHitPoints(int hitPoints) {
        super.setPierceHitPoints(hitPoints * getPierce() / 100);
    }

    @Override
    public int getPierce() {
        return piercePower;
    }
}
