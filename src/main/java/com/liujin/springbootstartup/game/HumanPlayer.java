package com.liujin.springbootstartup.game;

import java.util.Scanner;

/**
 * @author zonghuixu
 */
public class HumanPlayer extends Player {

	public HumanPlayer(String name) {
		this.tiles = Tile.values();
		this.name = name;
	}

	@Override
	public void play() {

		int choseValue = 0;
		// validate the tile human played is valid or not
		boolean needValidation = true;
		while (needValidation) {
			System.out.println("now you have tiles:");
			for (Tile tile : tiles) {
				System.out.print("[value:" + tile.getValue() + ", score:" + tile.getScore() + "] ");
			}
			System.out.println();

			System.out.println("please choose one value to play");
			Scanner scanner = new Scanner(System.in);
			choseValue = scanner.nextInt();

			for (Tile tile : tiles) {
				if (choseValue == tile.getValue()) {
					needValidation = false;
				}
			}

			if (needValidation) {
				System.out.println("you can not play a invalid tile!");
			}
		}

		this.playTile(choseValue);

	}

}
