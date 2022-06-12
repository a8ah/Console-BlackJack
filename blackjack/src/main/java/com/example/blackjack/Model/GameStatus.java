package com.example.blackjack.Model;

public enum GameStatus {

	NOTSTARTED("Not Started"),
	READY("Ready"),
	STARTED("Started"),
	ENDED("Ended");	

	private String name;

	private GameStatus(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

