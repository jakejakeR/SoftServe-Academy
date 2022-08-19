package com.warriors.command.damage;

import com.warriors.model.warrior.interfaces.IWarrior;

public interface IDamage {
    int getHitPoints();

    void setPierceHitPoints(int hitPoints);

    IWarrior getDamageDealer();
}