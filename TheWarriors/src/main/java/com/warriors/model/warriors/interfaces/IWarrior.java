package com.warriors.model.warriors.interfaces;

public interface IWarrior extends Attackable, HasHealth {
    default void hit(IWarrior opponent) {
        opponent.receiveHit(this);
    }

    default void receiveHit(Attackable damageDealer) {
        reduceHealthBasedOnDamage(damageDealer.getAttack());
    }
}
