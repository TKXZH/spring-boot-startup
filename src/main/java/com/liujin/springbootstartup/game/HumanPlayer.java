package com.liujin.springbootstartup.game;

import java.util.Scanner;

/**
 * @author zonghuixu
 */
public class HumanPlayer implements Player {
	private String name;
	private int score;
	private Tile[] tiles;
	private Tile lastTilePlayed;
	private int roundsWon;

	public HumanPlayer(String name) {
		this.tiles = Tile.values();
		this.name = name;
	}

	@Override
	public int play() {
		boolean tileSelected = true;
		while (true) {
			System.out.println("====================");
			System.out.println("now you have " + tiles.length + "tiles:");
			Scanner scanner = new Scanner(System.in);
			int tileValueSelected = scanner.nextInt();
			System.out.println("====================");
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Tile[] getTiles() {
		return tiles;
	}

	public void setTiles(Tile[] tiles) {
		this.tiles = tiles;
	}

	public Tile getLastTilePlayed() {
		return lastTilePlayed;
	}

	public void setLastTilePlayed(Tile lastTilePlayed) {
		this.lastTilePlayed = lastTilePlayed;
	}

	public int getRondsWon() {
		return roundsWon;
	}

	public void setRondsWon(int rondsWon) {
		this.roundsWon = rondsWon;
	}
}
