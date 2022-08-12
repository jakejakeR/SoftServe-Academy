package com.warriors.model.warrior.interfaces;

import com.warriors.model.equipment.Equipment;
import com.warriors.model.equipment.Weapon;

public interface HasEquipment {

    default void equipWeapon(Weapon weapon) {
        getEquipment().addWeapon(weapon);
    }

    Equipment getEquipment();
}
