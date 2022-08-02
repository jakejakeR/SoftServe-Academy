package com.warriors.model.warriors.interfaces;

public interface Fightable extends Attackable, HasHealth {
    default void hit(Fightable opponent) {
        opponent.receiveHit(this);
    }

    default void receiveHit(Attackable damageDealer) {
        reduceHealthBasedOnDamage(damageDealer.getAttack());
    }
}
