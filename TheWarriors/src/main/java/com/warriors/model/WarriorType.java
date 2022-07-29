package com.warriors.model;

import java.util.function.Supplier;

/**
 * Warrior Factory
 */
public enum WarriorType {

    WARRIOR(Warrior::new),
    KNIGHT(Knight::new);
//    DEFENDER(Defender::new);

    private final Supplier<Warrior> constructor;

    WarriorType(Supplier<Warrior> constructor) {
        this.constructor = constructor;
    }

    Supplier<Warrior> getConstructor() {
        return constructor;
    }
}
