package com.codingdojo.zookeeper;

public class Bat extends Mammal{
	Bat(){
		super.energyLevel = 300;
	}
	
	public void fly() {
		System.out.println("The sound of a bat taking off...");
		super.energyLevel -= 50;
		
	}
	public void eatHumans() {
		System.out.println("so- well, never mind");
		super.energyLevel += 25;
	}
	public void attackTown() {
		System.out.println("The sound of a town on fire...");
		super.energyLevel -= 100;
	}
}
