package com.warriors.model.warrior.interfaces;

public interface CanHeal {
    default void heal(IWarrior notSoHealthyWarrior) {
        var currentHealth = notSoHealthyWarrior.getHealth();
        int healthToSet = Math.min(notSoHealthyWarrior.getInitialHealth(), currentHealth + getHealPower());

        notSoHealthyWarrior.setHealth(healthToSet);
    }

    int getHealPower();
}
