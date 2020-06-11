package com.example.demo;

import com.example.demo.mobs.Player;

public class DemoApplication {

	public static void main(String[] args) {
		Player knight = Player.Builder.createPlayer().life(20).mana(0).name("Marvin").asKnight().build();
		Player enemy = Player.Builder.createPlayer().life(100).mana(0).name("Enemy").asKnight().build();
		knight.attack(enemy);
		knight.attack(enemy);
		System.out.println(enemy.stats());
		System.out.println(knight.stats());
		System.out.println();


		Player mage = Player.Builder.createPlayer().life(10).mana(20).name("Marvin2").asMage().build();
		mage.attack(enemy);
		mage.attack(enemy);
		System.out.println(enemy.stats());
		System.out.println(mage.stats());
		System.out.println();

		Player assassin = Player.Builder.createPlayer().life(15).mana(5).name("Marvin3").asAssassin().build();
		knight.attack(enemy);
		knight.attack(enemy);
		System.out.println(enemy.stats());
		System.out.println(	assassin.stats());
		System.out.println();
	}
}