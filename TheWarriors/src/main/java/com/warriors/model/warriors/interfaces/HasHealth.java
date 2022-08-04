package com.warriors.model.warriors.interfaces;

public interface HasHealth {
    default boolean isAlive() {
        return getHealth() > 0;
    }
    default void reduceHealthBasedOnDamage(int hitPoints) {
        setHealth(getHealth() - hitPoints);
    }
    int getHealth();
    void setHealth(int health);
}
