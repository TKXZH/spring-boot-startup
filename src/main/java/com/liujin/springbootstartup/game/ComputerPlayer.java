package com.liujin.springbootstartup.game;

/**
 * @author zonghuixu
 */
public class ComputerPlayer implements Player {

	private String name;
	private int score;
	private Tile[] tiles;
	private Tile lastTilePlayed;
	private int roundsWon;

	@Override
	public int play() {
		return 0;
	}
}
