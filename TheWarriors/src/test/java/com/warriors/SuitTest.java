package com.warriors;

import com.warriors.model.Knight;
import com.warriors.model.Warrior;
import com.warriors.service.Battle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void givenKnightHitsWarrior_WarriorHealthIsReducedBy7() {
        // arrange
        var knight = new Knight();
        var warrior = new Warrior();
        //act
        knight.hit(warrior);
        var remainingHealth = warrior.getHealth();
        // assert
        int expectedHealth = Warrior.INITIAL_HEALTH - Knight.ATTACK;
        assertEquals(expectedHealth, remainingHealth);
    }

    @Test
    void givenWarriorHitsKnight_KnightHealthIsReducedBy5() {
        // arrange
        var warrior = new Warrior();
        var knight = new Knight();
        // act
        warrior.hit(knight);
        var remainingHealth = knight.getHealth();
        // assert
        int expectedHealth = Knight.INITIAL_HEALTH - Warrior.ATTACK;
        assertEquals(expectedHealth, remainingHealth);
    }

    @Test
        // 1. Fight
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
        // 2. Fight
    void givenKnightFightsWarrior_thenKnightShouldWin() {
        // arrange
        var ramon = new Knight();
        var slevin = new Warrior();
        // act
        var result = Battle.fight(ramon, slevin);
        // assert
        assertTrue(result);
    }

    @Test
        // 3. Fight
    void givenWarriorFightsOtherWarrior_thenFirstWarriorShouldBeAlive() {
        // arrange
        var bob = new Warrior();
        var mars = new Warrior();
        // act
        Battle.fight(bob, mars);
        var result = bob.isAlive();
        // assert
        assertTrue(result);
    }

    @Test
        // 4. Fight
    void givenKnightFightsWarrior_thenKnightShouldBeAlive() {
        // arrange
        var zeus = new Knight();
        var godKiller = new Warrior();
        // act
        Battle.fight(zeus, godKiller);
        var result = zeus.isAlive();
        // assert
        assertTrue(result);
    }

    @Test
        // 5. Fight
    void givenWarriorFightsOtherWarrior_thenOtherShouldBeDead() {
        // arrange
        var husband = new Warrior();
        var wife = new Warrior();
        // act
        Battle.fight(husband, wife);
        var result = wife.isAlive();
        // assert
        assertFalse(result);
    }

    @Test
        // 6. Fight
    void givenWarriorFightsKnight_thenKnightShouldBeAlive() {
        // arrange
        var dragon = new Warrior();
        var knight = new Knight();
        // act
        Battle.fight(dragon, knight);
        var result = knight.isAlive();
        // assert
        assertTrue(result);
    }

    @Test
        // 7. Fight
    void givenKnightWinsWithWarriorAndFightsOtherWarrior_thenKnightShouldLose() {
        // arrange
        var unit1 = new Warrior();
        var unit2 = new Knight();
        var unit3 = new Warrior();
        // act
        Battle.fight(unit1, unit2);
        var result = Battle.fight(unit2, unit3);
        // assert
        assertFalse(result);
    }
}
