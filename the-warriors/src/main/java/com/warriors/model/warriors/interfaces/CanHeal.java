package com.warriors.model.warriors.interfaces;

public interface CanHeal {
    default void heal(HasHealth notSoHealthyWarrior) {
        var currentHealth = notSoHealthyWarrior.getHealth();
        int healthToSet = Math.min(notSoHealthyWarrior.getInitialHealth(), currentHealth + getHealPower());

        notSoHealthyWarrior.setHealth(healthToSet);
    }

    int getHealPower();
}
