package com.warriors.model.damage;

import com.warriors.command.ICommand;
import com.warriors.model.warrior.interfaces.IWarrior;

public class SimpleDamage implements IDamage, ICommand {
    private int hitPoints;
    private IWarrior damageDealer;

    public SimpleDamage(int hitPoints, IWarrior damageDealer) {
        this.hitPoints = hitPoints;
        this.damageDealer = damageDealer;
    }

    @Override
    public void setPierceHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
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
