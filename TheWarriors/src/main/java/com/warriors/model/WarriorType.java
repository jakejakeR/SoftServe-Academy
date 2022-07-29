package com.warriors.model;

import java.util.function.Supplier;

/**
 * Warrior Factory
 */
public enum WarriorType {

    WARRIOR(Warrior::new),
    KNIGHT(Knight::new),
    DEFENDER(Defender::new);

    private final Supplier<Unit> constructor;

    WarriorType(Supplier<Unit> constructor) {
        this.constructor = constructor;
    }

    Supplier<Unit> getConstructor() {
        return constructor;
    }
}
