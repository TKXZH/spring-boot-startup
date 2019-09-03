package com.liujin.springbootstartup.game;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zonghuixu
 */
public class Game {
	private static final String WELCOME_TIPS = "Please select from the following options\n"
		+ "Press 1 to register a player\n"
		+ "Press 2 to start a new game\n"
		+ "Press 3 to view a help menu\n"
		+ "Press 4 to exit";

	public static void main(String[] args) {
		Game game = new Game();
		Player humanPlayer = null;
		Player computerPlayer = new ComputerPlayer();
		while (true) {
			System.out.println(WELCOME_TIPS);
			Scanner scanner = new Scanner(System.in);
			int selectedOption = scanner.nextInt();

			switch (selectedOption) {
				case 1:
					humanPlayer = game.registerHumanPlayer();
					break;
				case 2:
					game.createNewGame(humanPlayer, computerPlayer);
					break;
				case 3:
					break;
				case 4:
					System.exit(0);
					break;
				default:
					break;
			}
		}
	}

	private Player registerHumanPlayer() {
		System.out.println("please enter you name(between 3 and 10 characters inclusive):");
		boolean playerNameCheck = true;
		Scanner scanner = new Scanner(System.in);
		String userName = null;
		while (playerNameCheck) {
			userName = scanner.next();
			int length = userName.length();
			if (length >= 3 && length <= 10) {
				playerNameCheck = false;
			} else {
				System.out.println("please input valid user name!");
			}
		}
		System.out.println("welcome " + userName + "!");
		return new HumanPlayer(userName);
	}

	private void createNewGame(Player humanPlayer, Player computerPlayer) {
		// validate if the human player is registered
		if (humanPlayer == null) {
			System.out.println("please register player first!");
			return;
		}

		RNG rng = new RNG(1, 0);

		System.out.println("please input rounds you want to play");
		int round = new Scanner(System.in).nextInt();
		for (int i = 0; i < round; i++) {
			System.out.println("new round starts!");
			Player currentPlayer = null;
			if (rng.randomValue() == 1) {
				currentPlayer = humanPlayer;
			} else {
				currentPlayer = computerPlayer;
			}

			int totalValue = 0;
			while (totalValue <= 21) {
				currentPlayer.play();

				// sum the value, check if the game should be ended, calculate the score
				totalValue += currentPlayer.getLastTilePlayed().getValue();
				System.out.println("now, total value is " + totalValue);
				if (totalValue >= 21) {
					int humanScore = humanPlayer.getScore();
					int computerScore = computerPlayer.getScore();

					// who did not use 5, will get penalty
					if (!Arrays.asList(humanPlayer.getTiles()).contains(Tile.TILE5)) {
						humanScore -= 3;
					}
					if (!Arrays.asList(computerPlayer.getTiles()).contains(Tile.TILE5)) {
						computerScore -= 3;
					}

					if (humanScore > computerScore) {
						humanPlayer.setRondsWon(humanPlayer.getRondsWon() + 1);
						System.out.println(humanPlayer.getName() + " win!");
					} else {
						computerPlayer.setRondsWon(computerPlayer.getRondsWon() + 1);
						System.out.println(computerPlayer.getName() + " win!");
					}
					humanPlayer.reset();
					computerPlayer.reset();
					break;
				}
				//turn exchange
				if (currentPlayer == humanPlayer) {
					currentPlayer = computerPlayer;
				} else {
					currentPlayer = humanPlayer;
				}
			}
		}

		if (humanPlayer.getRondsWon() > computerPlayer.getRondsWon()) {
			System.out.println("finally, human win!");
		} else {
			System.out.println("finally, computer win!");
		}
	}
}
