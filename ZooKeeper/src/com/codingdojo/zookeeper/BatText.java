package com.codingdojo.zookeeper;

public class BatText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bat b = new Bat();
		System.out.println(b.displayEnergy());
		b.fly();
		System.out.println(b.displayEnergy());
		b.fly();
		System.out.println(b.displayEnergy());
		b.eatHumans();
		System.out.println(b.displayEnergy());
		b.eatHumans();
		System.out.println(b.displayEnergy());
		b.attackTown();
		System.out.println(b.displayEnergy());
		b.attackTown();
		System.out.println(b.displayEnergy());
		b.attackTown();
		System.out.println(b.displayEnergy());
	}

}
