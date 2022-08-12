package com.warriors.model.equipment;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Weapon {
    private int attack;
    private int health;
    private int defense;
    private int vampirism;
    private int healPower;
}
