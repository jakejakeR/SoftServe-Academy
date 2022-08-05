package com.warriors.service;

import com.warriors.model.warriors.Knight;
import com.warriors.model.warriors.Warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class FightTestSuite {

    @Test // 1. Fight
    void givenWarriorAndKnight_whenFightEachOther_thenKnightShouldWinWithHealth10() {
        // given
        var warrior = new Warrior();
        var knight = new Knight();

        // when
        var result = Battle.fight(warrior, knight);

        // then
        int expectedHealthOfKnight = 10;
        int actualHealthOfKnight = knight.getHealth();
        assertEquals(expectedHealthOfKnight, actualHealthOfKnight);
        assertFalse(result);
    }
}