package com.warriors.model.equipment;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Weapon {
    private String name;
    private int attack;
    private int health;
    private int defense;
    private int vampirism;
    private int healPower;
    private boolean isApplied;

    public void setApplied(boolean applied) {
        isApplied = applied;
    }

    @Override
    public String toString() {
        return name +  ": [" +
                "attack=" + attack +
                ", health=" + health +
                ", defense=" + defense +
                ", vampirism=" + vampirism +
                ", healPower=" + healPower +
                ']';
    }
}
