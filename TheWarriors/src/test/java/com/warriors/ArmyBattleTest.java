package com.warriors;

import com.warriors.model.Army;
import com.warriors.model.Knight;
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
        var anotherArmy = new Army();

        attackingArmy.addUnits(Unit.Type.WARRIOR, 2).addUnits(Unit.Type.WARRIOR, 1);
        defendingArmy.addUnits(Unit.Type.WARRIOR, 3);
        anotherArmy.addUnits(Unit.Type.WARRIOR, 3);
        knightsArmy.addUnits(Knight::new, 3);

        assertTrue(Battle.fight(attackingArmy, defendingArmy));
        assertFalse(Battle.fight(anotherArmy, knightsArmy));
    }
}