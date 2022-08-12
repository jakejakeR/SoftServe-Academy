package com.warriors.model.warrior.interfaces;

public interface HasHealth {
    default boolean isAlive() {
        return getHealth() > 0;
    }

    int getHealth();
}
