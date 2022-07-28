package com.warriors;

import com.warriors.model.Army;
import com.warriors.model.Knight;
import com.warriors.model.Unit;
import com.warriors.model.Warrior;
import com.warriors.service.Battle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArmyBattleTest {

    @Test
    void smokeTest() {
        var attackingArmy = new Army();
        var defendingArmy = new Army();
        var knightsArmy = new Army();
        var anotherArmy = new Army();

        attackingArmy.addUnits(Unit.Type.WARRIOR, 2).addUnits(Unit.Type.WARRIOR, 1);
        defendingArmy.addUnits(Unit.Type.WARRIOR, 3);
        Warrior prototype = new Warrior();
        anotherArmy.addUnits(prototype, 2).addUnits(prototype, 1);
        knightsArmy.addUnits(Knight::new, 2).addUnits(Knight::new, 1);

        assertTrue(Battle.fight(attackingArmy, defendingArmy));
        assertFalse(Battle.fight(anotherArmy, knightsArmy));
    }
}