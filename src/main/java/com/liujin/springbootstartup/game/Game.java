package com.liujin.springbootstartup.game;

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

	private Player humanPlayer;
	private Player computerPlayer;

	public static void main(String[] args) {
		Game game = new Game();

		while (true) {
			System.out.println(WELCOME_TIPS);
			Scanner scanner = new Scanner(System.in);
			int selectedOption = scanner.nextInt();

			Player player1 = null;
			Player player2 = new ComputerPlayer();
			switch (selectedOption) {
				case 1:
					player1 = game.registerHumanPlayer();
					break;
				case 2:
					game.createNewGame(player1, player2);
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

	private void createNewGame(Player player1, Player player2) {
		int round = new Scanner(System.in).nextInt();
		for (int i = 0; i < round; i++) {
			int totalValue = 0;
			while (totalValue <= 21) {

			}
		}
	}
}
