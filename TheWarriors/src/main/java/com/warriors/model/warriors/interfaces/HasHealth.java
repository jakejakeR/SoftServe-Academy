package com.warriors.model.warriors.interfaces;

public interface HasHealth {
    default boolean isAlive() {
        return getHealth() > 0;
    }
    void reduceHealthBasedOnDamage(int damage);
    int getHealth();
    void setReceivedDamage(int damage);
    int getReceivedDamage();
}
