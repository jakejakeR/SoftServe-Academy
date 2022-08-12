package com.warriors.model.warrior.interfaces;

@FunctionalInterface
public interface CanHeal {
    default void heal(HasHealth notSoHealthyWarrior) {
        var currentHealth = notSoHealthyWarrior.getHealth();
        int healthToSet = Math.min(notSoHealthyWarrior.getInitialHealth(), currentHealth + getHealPower());

        notSoHealthyWarrior.setHealth(healthToSet);
    }

    int getHealPower();
}
