package com.warriors.model.weapon;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Weapon {
    private int attack;
    private int health;
    private int defense;
    private int vampirism;
    private int healPower;
}
