package com.warriors.model.damage;

public class SimpleDamage implements IDamage {
    private final int hitPoints;

    public SimpleDamage(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    @Override
    public int getHitPoints() {
        return hitPoints;
    }
}
