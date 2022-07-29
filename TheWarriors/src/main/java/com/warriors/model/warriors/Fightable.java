package com.warriors.model.warriors;

import com.warriors.model.damage.Damage;

public interface Fightable {
    boolean isAlive();
    void hit(Fightable opponent);
    void receiveDamage(Damage damage, Fightable damageDealer);
}
