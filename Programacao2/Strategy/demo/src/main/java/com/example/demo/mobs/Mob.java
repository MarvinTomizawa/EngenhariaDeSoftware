package com.example.demo.mobs;

import com.example.demo.weapon.Weapon;

public abstract class Mob {
    private Weapon weapon;

    private int life = 100;

    public void attack(Mob mob){
        if(weapon != null){
            weapon.attack(mob);
        }else{
            mob.takeDamage(1);
        }

    }

    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    public void takeDamage(int damageTaken){
        life -= damageTaken;
    }

    public boolean isAlive(){
        return life >= 0;
    }

    public int getLife(){
        return life;
    }
}