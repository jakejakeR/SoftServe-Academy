package com.warriors.model;

public interface Fightable {
    boolean isAlive();
    void hit(Fightable opponent);
    void receiveDamage(Damage damage, Fightable damageDealer);
}
