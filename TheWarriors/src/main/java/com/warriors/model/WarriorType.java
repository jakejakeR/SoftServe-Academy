package com.warriors.model;

import java.util.function.Supplier;

public enum WarriorType {

    WARRIOR(Warrior::new),
    KNIGHT(Knight::new);

    private final Supplier<Unit> constructor;

    WarriorType(Supplier<Unit> constructor) {
        this.constructor = constructor;
    }

    Supplier<Unit> getConstructor() {
        return constructor;
    }
}
