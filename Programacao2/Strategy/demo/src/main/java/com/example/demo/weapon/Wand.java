package com.example.demo.weapon;

import com.example.demo.mobs.Player;

import java.util.Random;

public class Wand implements Weapon {
    @Override
    public String toString() {
        return "Wand";
    }

    @Override
    public void attack(Player mob) {
        int damageTaken = new Random().nextInt(20);
        mob.takeDamage(damageTaken);
        System.out.println("Magia de dano " + damageTaken);
    }
}
