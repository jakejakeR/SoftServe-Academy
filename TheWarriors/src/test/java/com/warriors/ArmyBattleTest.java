package com.warriors;

import com.warriors.model.Army;
import com.warriors.model.Unit;
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

        attackingArmy.addUnits(Unit.Type.WARRIOR, 3);
        defendingArmy.addUnits(Unit.Type.WARRIOR, 3);
        knightsArmy.addUnits(Unit.Type.KNIGHT, 3);


        assertTrue(Battle.fight(attackingArmy, defendingArmy));
        assertFalse(Battle.fight(attackingArmy, knightsArmy));
    }
}