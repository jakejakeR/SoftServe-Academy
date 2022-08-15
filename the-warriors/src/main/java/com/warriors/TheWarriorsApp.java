package com.warriors;

import com.warriors.model.warrior.Defender;
import com.warriors.model.warrior.Lancer;
import com.warriors.model.warrior.interfaces.Warlord;

/**
 * The Warriors app!
 */
public class TheWarriorsApp {
    public static void main(String[] args) {
        System.out.println("Let the battle begin!");
        var deadA = new Lancer();
        var deadB = new Defender();

        Warlord warlord = new Warlord();
        System.out.println(warlord.compare(deadA, deadB));
        System.out.println(warlord.compare(deadB, deadA));

        System.out.println(deadA.getAttack());
    }
}
