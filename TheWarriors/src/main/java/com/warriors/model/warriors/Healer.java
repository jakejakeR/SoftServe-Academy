package com.warriors.model.warriors;

import com.warriors.model.command.HealCommand;
import com.warriors.model.command.ICommand;
import com.warriors.model.warriors.interfaces.CanHeal;
import com.warriors.model.warriors.interfaces.IWarrior;

public class Healer extends Warrior implements CanHeal {
    public static final int INITIAL_HEALTH = 60;
    public static final int INITIAL_HEAL_POWER = 2;
    private int healPower;

    public Healer() {
        super(INITIAL_HEALTH, INITIAL_ATTACK);
    }

    @Override
    public void processCommand(ICommand command, IWarrior sender) {
        if (command instanceof HealCommand) {
            heal(sender);
        }
        super.processCommand(command, sender);
    }

    @Override
    public int getHealPower() {
        return healPower;
    }
}
