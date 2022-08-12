package com.warriors.model.equipment;

import java.util.ArrayList;
import java.util.List;

public class Equipment {
    private final List<Weapon> weapons = new ArrayList<>();

    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
    }

    public int getHealthModifiers() {
        return weapons.stream().mapToInt(Weapon::getHealth).sum();
    }
    public int getNonAppliedHealthModifiers() {
        return weapons.stream().filter(weapon -> !weapon.isApplied()).mapToInt(Weapon::getHealth).sum();
    }

    public int getAttackModifiers() {
        return weapons.stream().mapToInt(Weapon::getAttack).sum();
    }

    public int getDefenseModifiers() {
        return weapons.stream().mapToInt(Weapon::getDefense).sum();
    }

    public int getVampirismModifiers() {
        return weapons.stream().mapToInt(Weapon::getVampirism).sum();
    }

    public int getHealPowerModifiers() {
        return weapons.stream().mapToInt(Weapon::getHealPower).sum();
    }
}
