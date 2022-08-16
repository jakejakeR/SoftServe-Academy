package com.warriors.model.warrior.interfaces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface HasHealth {
    Logger LOGGER = LoggerFactory.getLogger("DAMAGE LOG");
    default boolean isAlive() {
        return getHealth() > 0;
    }

    default void reduceHealthBasedOnDamage(int hitPoints) {
        LOGGER.debug("{} receives damage: {}", this, hitPoints);
        setHealth(getHealth() - hitPoints);
    }

    int getHealth();

    int getInitialHealth();

    void setHealth(int health);
}
