package com.warriors.model.warrior.decorator;

import com.warriors.model.warrior.interfaces.CanHeal;
import com.warriors.model.warrior.interfaces.HasDefense;
import com.warriors.model.warrior.interfaces.IWarrior;
import com.warriors.model.warrior.interfaces.Vampirism;
import com.warriors.model.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;

public class EquippedWarrior implements IWarrior {
    private int initialAttack;
    private int initialHealth;
    private int initialDefense;
    private int initialVampirism;
    private int initialHealPower;

    private final IWarrior decorated;
    private final List<Weapon> equipment = new ArrayList<>();

    public EquippedWarrior(IWarrior decorated) {
        this.decorated = decorated;
    }
    
    public void equipWeapon(Weapon... weapons) {
        equipment.addAll(List.of(weapons));
        applyModifiers();
    }

    private void applyModifiers() {
        for (Weapon weapon : equipment) {
            this.initialAttack = decorated.getAttack() + weapon.getAttack();
            this.initialHealth = decorated.getInitialHealth() + weapon.getHealth();
            if (decorated instanceof HasDefense defenseGuy) {
                this.initialDefense = defenseGuy.getDefense() + weapon.getDefense();
            }
            if (decorated instanceof Vampirism vampireGuy) {
                this.initialVampirism = vampireGuy.getVampirism() + weapon.getVampirism();
            }
            if (decorated instanceof CanHeal healGuy) {
                this.initialHealPower = healGuy.getHealPower() + weapon.getHealPower();
            }
        }
    }

    @Override
    public int getAttack() {
        return initialAttack;
    }

    @Override
    public int getHealth() {
        return initialHealth;
    }

    @Override
    public int getInitialHealth() {
        return decorated.getInitialHealth();
    }

    @Override
    public void setHealth(int health) {
        decorated.setHealth(health);
    }
}
