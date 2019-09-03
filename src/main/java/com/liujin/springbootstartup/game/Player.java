package com.liujin.springbootstartup.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author zonghuixu
 */
public class Player {
	String name;
	int score;
	Tile[] tiles;
	Tile lastTilePlayed;
	int roundsWon;

	public Player(String name) {
		this.tiles = Tile.values();
		this.name = name;
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

	public void play() {

	}

	public void playTile(int value) {

		System.out.println("player " + name + " played: " + value);
		List<Tile> tileList = new ArrayList<>(Arrays.asList(tiles));
		Iterator<Tile> tileIterator = tileList.iterator();
		while (tileIterator.hasNext()) {
			Tile tile = tileIterator.next();
			if (tile.getValue() == value) {
				tileIterator.remove();
			}
		}
		this.tiles = tileList.toArray(new Tile[tileList.size()]);
		this.score += getTileByValue(value).getScore();
		System.out.println("now, player " + name + " score is " + score);

		this.lastTilePlayed = getTileByValue(value);
	}

	private Tile getTileByValue(int value) {
		Tile tile = null;
		for (Tile tileItem : Tile.values()) {
			if (value == tileItem.getValue()) {
				tile = tileItem;
			}
		}
		return tile;
	}

	public void reset() {
		this.score = 0;
		this.tiles = Tile.values();
		this.lastTilePlayed = null;
	}

	public boolean penalty() {
		return Arrays.asList(this.getTiles()).contains(Tile.TILE5);
	}

	public void printTiles() {
		System.out.println("now you have tiles:");
		for (Tile tile : this.getTiles()) {
			System.out.print("[value:" + tile.getValue() + ", score:" + tile.getScore() + "] ");
		}
		System.out.println();
	}

	public boolean validateTile(int choseValue) {
		for (Tile tile : this.getTiles()) {
			if (choseValue == tile.getValue()) {
				return true;
			}
		}
		return false;
	}
}
