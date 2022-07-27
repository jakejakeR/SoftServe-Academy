package com.warriors;

import com.warriors.model.Knight;
import com.warriors.model.Warrior;
import com.warriors.service.Battle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SuitTest {

    @Test
    void smokeTest() {
        var chuck = new Warrior();
        var bruce = new Warrior();
        var carl = new Knight();
        var dave = new Warrior();

        assertTrue(Battle.fight(chuck, bruce));
        assertFalse(Battle.fight(dave, carl));

        assertTrue(chuck.isAlive());
        assertFalse(bruce.isAlive());
        assertTrue(carl.isAlive());
        assertFalse(dave.isAlive());
    }

    @Test
    @DisplayName("1. Fight: Warrior vs Knight, then Knight should win")
    void givenWarriorFightsKnight_thenKnightShouldWin() {
        // arrange
        var carl = new Warrior();
        var jim = new Knight();
        //act
        var result = Battle.fight(carl, jim);
        //assert
        assertFalse(result);
    }

    @Test
    void givenKnightFightsWarrior_thenKnightShouldWin() {
        // arrange
        var ramon = new Knight();
        var slevin = new Warrior();
        // act
        var result = Battle.fight(ramon, slevin);
        // assert
        assertTrue(result);
    }
}
