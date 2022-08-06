package com.warriors.model.warriors;

import com.warriors.model.command.HealCommand;
import com.warriors.model.command.ICommand;
import com.warriors.model.warriors.interfaces.CanHeal;
import com.warriors.model.warriors.interfaces.IWarrior;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Healer extends Warrior implements CanHeal {
    public static final int INITIAL_HEALTH = 60;
    public static final int INITIAL_HEAL_POWER = 2;
    private int healPower;

    public Healer() {
        super(INITIAL_HEALTH, INITIAL_ATTACK);
        healPower = INITIAL_HEAL_POWER;
    }

    @Override
    public void hit(IWarrior opponent) {
    }

    @Override
    public void processCommand(ICommand command, IWarrior sender) {
        if (command instanceof HealCommand) {
            int healthBeforeHeal = sender.getHealth();
            heal(sender);
            LOGGER.info(
                    "{} heals injured {} and increases his health from {} to {}.",
                    this, sender, healthBeforeHeal, sender.getHealth()
            );
        }
        super.processCommand(command, sender);
    }

    @Override
    public int getHealPower() {
        return healPower;
    }
}
