package com.warriors.model.weapon;

public class Forge {

    private Forge() {
        throw new IllegalStateException("Utility class");
    }

    public static Weapon.WeaponBuilder forgeCustomWeapon() {
        return Weapon.builder();
    }

    public static Weapon forgeSword() {
        return Weapon.builder()
                .attack(2)
                .health(5)
                .build();
    }

    public static Weapon forgeShield() {
        return Weapon.builder()
                .attack(-1)
                .defense(2)
                .health(20)
                .build();
    }

    public static Weapon forgeGreatAxe() {
        return Weapon.builder()
                .attack(5)
                .health(-15)
                .defense(-2)
                .vampirism(20)
                .build();
    }

    public static Weapon forgeKatana() {
        return Weapon.builder()
                .attack(6)
                .health(-20)
                .defense(-5)
                .vampirism(50)
                .build();
    }

    public static Weapon forgeMagicWand() {
        return Weapon.builder()
                .attack(3)
                .health(30)
                .healPower(3)
                .build();
    }
}
