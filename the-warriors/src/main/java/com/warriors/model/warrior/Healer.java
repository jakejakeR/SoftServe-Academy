package com.warriors.model.warrior;

import com.warriors.command.HealCommand;
import com.warriors.command.ICommand;
import com.warriors.model.warrior.interfaces.CanHeal;
import com.warriors.model.warrior.interfaces.IWarrior;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "HEALER LOG")
public class Healer extends Warrior implements CanHeal {
    public static final int INITIAL_HEALTH = 60;
    public static final int INITIAL_HEAL_POWER = 2;
    private final int healPower;

    public Healer() {
        super(INITIAL_HEALTH, INITIAL_ATTACK);
        healPower = INITIAL_HEAL_POWER;
    }

    @Override
    public void hit(IWarrior opponent) {
        // ignore because healer has 0 points attack
    }

    @Override
    public void processCommand(ICommand command, IWarrior sender) {
        if ((command instanceof HealCommand) && sender.getHealth() < sender.getInitialHealth() && this.isAlive() && sender.isAlive()) {
            LOGGER.debug(
                    "{} heals injured {} and increases his health by {}.",
                    this, sender, getHealPower()
            );
            heal(sender);
            return;
        }
        super.processCommand(command, sender);
    }

    @Override
    public int getHealPower() {
        return healPower + equipment.getHealPowerModifiers();
    }

    @Override
    public int getInitialHealth() {
        return INITIAL_HEALTH + equipment.getHealthModifiers();
    }

    @Override
    public int getAttack() {
        return 0;
    }
}
