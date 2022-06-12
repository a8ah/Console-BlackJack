package com.example.blackjack.Model;

public enum CardName {
	TWO("2"),
	THREE("3"),
	FOURE("4"),
	FIVE("5"),
	SIX("6"),
	SEVEN("7"),
	EIGTH("8"),
	NINE("9"),
	TEN("10"),
	J("Jack"),
	Q("Queen"),
	K("King"),
	ACE("Ace");

	private String name;

	private CardName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
