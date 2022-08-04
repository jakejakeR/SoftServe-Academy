package com.warriors.model.warriors.interfaces;

import com.warriors.model.damage.IDamage;
import com.warriors.model.damage.SimpleDamage;

public interface IWarrior extends CanAttack, HasHealth {
    default void hit(IWarrior opponent) {
        opponent.receiveDamage(new SimpleDamage(getAttack(), this));
    }

    default void receiveDamage(IDamage damage) {
        reduceHealthBasedOnDamage(damage.hitPoints());
    }
}
