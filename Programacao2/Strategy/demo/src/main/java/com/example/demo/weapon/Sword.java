package com.example.demo.weapon;

import com.example.demo.mobs.Player;

public class Sword implements Weapon {
    @Override
    public String toString() {
        return "Sword";
    }

    @Override
    public void attack(Player mob) {
        mob.takeDamage(5);
        System.out.println("Ataque padrão");
    }
}
