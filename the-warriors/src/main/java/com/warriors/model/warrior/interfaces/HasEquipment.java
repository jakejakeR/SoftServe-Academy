package com.warriors.model.warrior.interfaces;

import com.warriors.model.equipment.Equipment;
import com.warriors.model.equipment.Weapon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@FunctionalInterface
public interface HasEquipment {

    Logger LOGGER = LoggerFactory.getLogger("EQUIPMENT LOG");

    default HasEquipment equipWeapon(Weapon weapon) {
        getEquipment().addWeapon(weapon);
        LOGGER.debug("{} now wields a {}.", this, weapon);
        return this;
    }

    default void dropEquipment() {
        getEquipment().removeWeapons();
    }

    Equipment getEquipment();
}
