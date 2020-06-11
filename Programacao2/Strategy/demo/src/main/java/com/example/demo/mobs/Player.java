package com.example.demo.mobs;

import com.example.demo.weapon.Dagger;
import com.example.demo.weapon.Sword;
import com.example.demo.weapon.Wand;
import com.example.demo.weapon.Weapon;

public class Player{
    private String name;
    private Weapon weapon;
    private int life;
    private int mana;
    private ClassType classType;

    private Player(){

    }

    public void attack(Player enemy){
        weapon.attack(enemy);
    }

    public void takeDamage(int damageTaken){
        life -= damageTaken;
    }

    public String stats(){
        return "Player " + name + " Class:" + classType + " mana:" + mana + " life:" + life + " weapon:" + weapon.toString();
    }

    public static class Builder{
        private String name;
        private Weapon weapon;
        private int life;
        private int mana;
        private ClassType classType;

        public static Builder createPlayer(){
            return new Builder();
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder asKnight(){
            this.classType = ClassType.KNIGHT;
            this.weapon = new Sword();
            return this;
        }

        public Builder asMage(){
            this.classType = ClassType.MAGE;
            this.weapon = new Wand();
            return this;
        }

        public Builder asAssassin(){
            this.classType = ClassType.ASSASSIN;
            this.weapon = new Dagger();
            return this;
        }

        public Builder life(int life){
            this.life = life;
            return this;
        }

        public Builder mana(int mana) {
            this.mana = mana;
            return this;
        }

        public Player build(){
            Player player = new Player();
            player.name = this.name;
            player.weapon = this.weapon;
            player.life = this.life;
            player.mana = this.mana;
            player.classType = this.classType;
            return player;
        }
    }
}

