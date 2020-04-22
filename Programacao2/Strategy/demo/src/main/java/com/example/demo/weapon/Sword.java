package com.example.demo.weapon;

import com.example.demo.mobs.Mob;

public class Sword implements Weapon {
    @Override
    public void attack(Mob mob) {
        mob.takeDamage(5);
        System.out.println("Ataque padrão");
    }
}
