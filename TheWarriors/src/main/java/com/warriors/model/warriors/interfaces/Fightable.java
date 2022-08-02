package com.warriors.model.warriors.interfaces;

public interface Fightable extends Attackable, HasHealth {
    default void hit(Fightable opponent) {
        opponent.receiveHit(this);
    }

    default void receiveHit(Attackable damageDealer) {
        int damage = damageDealer.getAttack();
        reduceHealthBasedOnDamage(damage);
        setReceivedDamage(damage);
    }
}
