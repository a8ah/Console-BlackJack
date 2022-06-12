package com.example.blackjack.Model;

public enum Shape {

	HEARTS("Hearts"),
	SPADES("Spades"),
	CLUBS("Clubs"),
	DIAMONDS("Diamonds");

	private String name;

	private Shape(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

