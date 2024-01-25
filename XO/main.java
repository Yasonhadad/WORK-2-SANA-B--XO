package XO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Game game;
		Player player1, player2;
        // Prompting the user to choose the type of game
		System.out.println("Select the game type:");
		System.out.println("1. User game");
		System.out.println("2. Self game");
		System.out.print("Enter your choice (1 or 2): ");
		int choice = input.nextInt();
        // Setup the game based on the user's choice
		if (choice == 1) {
			game = new UserGame();
			player1 = new UserPlayer(PlayerType.X, game);
			player2 = new SelfPlayer(PlayerType.O, game);
		} else {
			game = new SelfGame();
			player1 = new SelfPlayer(PlayerType.X, game);
			player2 = new SelfPlayer(PlayerType.O, game);
		}

		player1.start();
		player2.start();
	}

}
