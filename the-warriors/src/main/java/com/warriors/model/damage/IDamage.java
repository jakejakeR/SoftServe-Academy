package com.warriors.model.damage;

import com.warriors.model.warriors.interfaces.IWarrior;

public interface IDamage {
    int getHitPoints();

    IWarrior getDamageDealer();
}