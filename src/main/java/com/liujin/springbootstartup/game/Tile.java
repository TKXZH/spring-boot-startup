package com.liujin.springbootstartup.game;

/**
 * @author zonghuixu
 */
public enum Tile {
	TILE1(1, 5),
	TILE2(2, 4),
	TILE3(3, 3),
	TILE5(5, 2),
	TILE7(7, 1);

	Tile(int value, int score) {
		this.score = value;
		this.score = score;
	}

	private int score;
	private int value;

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
