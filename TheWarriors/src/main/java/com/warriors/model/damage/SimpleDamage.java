package com.warriors.model.damage;

import com.warriors.model.warriors.interfaces.IWarrior;

public class SimpleDamage implements IDamage {
    private int hitPoints;
    private IWarrior damageDealer;

    public SimpleDamage(int hitPoints, IWarrior damageDealer) {
        this.hitPoints = hitPoints;
        this.damageDealer = damageDealer;
    }

    @Override
    public int getHitPoints() {
        return hitPoints;
    }

    @Override
    public IWarrior getDamageDealer() {
        return damageDealer;
    }
}
