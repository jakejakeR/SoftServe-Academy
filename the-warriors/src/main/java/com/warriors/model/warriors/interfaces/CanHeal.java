package com.warriors.model.warriors.interfaces;

public interface CanHeal {
    default void heal(HasHealth notSoHealthyWarrior) {
        var currentHealth = notSoHealthyWarrior.getHealth();
        notSoHealthyWarrior.setHealth(currentHealth + getHealPower());
    }

    int getHealPower();
}
