package com.liujin.springbootstartup.game;

/**
 * @author zonghuixu
 */
public class ComputerPlayer extends Player {

	public ComputerPlayer() {
		this.tiles = Tile.values();
		this.name = "computer";
	}

	@Override
	public void play() {
		RNG rng = new RNG(this.getTiles().length - 1, 0);
		this.playTile(this.getTiles()[rng.randomValue()].getValue());
	}
}
