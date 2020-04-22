package com.example.demo.weapon;

import com.example.demo.mobs.Mob;

import java.util.Random;

public class Wand implements Weapon {
    @Override
    public void attack(Mob mob) {
        int damageTaken = new Random().nextInt(20);
        mob.takeDamage(damageTaken);
        System.out.println("Magia de dano " + damageTaken);
    }
}
