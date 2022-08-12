package com.warriors.model.warrior.interfaces;

import com.warriors.model.equipment.Equipment;
import com.warriors.model.equipment.Weapon;

@FunctionalInterface
public interface HasEquipment {

    default HasEquipment equipWeapon(Weapon weapon) {
        getEquipment().addWeapon(weapon);
        return this;
    }

    Equipment getEquipment();
}
