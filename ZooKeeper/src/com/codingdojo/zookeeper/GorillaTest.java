package com.codingdojo.zookeeper;

public class GorillaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gorilla m = new Gorilla();
		System.out.println(m.displayEnergy());
		m.throwSomething();
		System.out.println(m.displayEnergy());
		m.eatBananas();
		System.out.println(m.displayEnergy());
		m.eatBananas();
		System.out.println(m.displayEnergy());
		m.climb();
		System.out.println(m.displayEnergy());
	}

}
