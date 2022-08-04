package com.codingdojo.zookeeper;

public class Gorilla extends Mammal{
	public void throwSomething() {
		System.out.println("Gorilla has thrown something...");
		super.energyLevel -=5;
	}
	public void eatBananas() {
		System.out.println("Eating bananas...");
		super.energyLevel +=10;
	}
	public void climb() {
		System.out.println("The gorilla has climbed a tree...");
		super.energyLevel -=10;
	}

}
