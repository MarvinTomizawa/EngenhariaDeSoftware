package com.example.demo.weapon;

import com.example.demo.mobs.Player;

import java.util.Random;

public class Dagger implements Weapon {
    @Override
    public String toString() {
        return "Dagger";
    }

    @Override
    public void attack(Player mob) {
        int critChance = new Random().nextInt(5);
        if(critChance > 3){
            mob.takeDamage(10);
            System.out.println("Ataque Critico");
        }else{
            mob.takeDamage(2);
            System.out.println("Ataque Fraco");
        }

    }
}
