package com.warriors.model.warriors.interfaces;

public interface HasHealth {
    default boolean isAlive() {
        return getHealth() > 0;
    }
    default void reduceHealthBasedOnDamage(int damage) {
        setHealth(getHealth() - damage);
    }
    int getHealth();
    void setHealth(int i);
}
