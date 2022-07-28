package com.warriors.model;

import java.util.function.Supplier;

public interface Unit {
    enum Type {
        WARRIOR(Warrior::new),
        KNIGHT(Knight::new);

        private final Supplier<Unit> constructor;

        Type(Supplier<Unit> constructor) {
            this.constructor = constructor;
        }

        Supplier<Unit> getConstructor() {
            return constructor;
        }
    }
}
