package com.warriors.model.warriors.interfaces;

public interface HasHealth {
    default boolean isAlive() {
        return getHealth() > 0;
    }
    int getHealth();
    void setHealth(int health);
}
