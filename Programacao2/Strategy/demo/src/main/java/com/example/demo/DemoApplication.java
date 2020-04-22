package com.example.demo;

import com.example.demo.mobs.Goblin;
import com.example.demo.mobs.Knight;
import com.example.demo.weapon.Dagger;
import com.example.demo.weapon.Wand;

public class DemoApplication {

	public static void main(String[] args) {
		Knight knight = new Knight();
		Goblin goblin1 = new Goblin();
		Goblin goblin2 = new Goblin();
		Goblin goblin3 = new Goblin();

		System.out.println("Atacando com uma espada");
		knight.attack(goblin1);
		knight.attack(goblin1);
		System.out.println("Vida do goblin 1:" + goblin1.getLife());


		System.out.println("Atacando com uma adaga");
		knight.setWeapon(new Dagger());
		knight.attack(goblin2);
		knight.attack(goblin2);
		System.out.println("Vida do goblin 2:" +goblin2.getLife());


		System.out.println("Atacando com um cajado mágico");
		knight.setWeapon(new Wand());
		knight.attack(goblin3);
		knight.attack(goblin3);
		System.out.println("Vida do goblin 3:" +goblin3.getLife());
	}

}