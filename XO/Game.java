package XO;

import java.util.ArrayList;
import java.util.List;

public abstract class Game {
	protected char gameboard[][] = new char[5][5];
	protected PlayerType currentPlayer = PlayerType.X;

	public Game() {
		if (this instanceof SelfGame) {
			System.out.println("Self game start.");
		} else
			System.out.println("User game start.");
		// Initialize the game board with empty spaces
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				gameboard[i][j] = ' ';
			}
		}
		printBoard();
	}

	public void printBoard() {
		// Printing the top border of the board
		System.out.print("+");
		for (int i = 0; i < gameboard[0].length; i++) {
			System.out.print("---+");
		}
		System.out.println();

		// Printing the board content with vertical and horizontal separators
		for (int i = 0; i < gameboard.length; i++) {
			System.out.print("|");
			for (int j = 0; j < gameboard[i].length; j++) {
				System.out.print(" " + gameboard[i][j] + " |");
			}
			System.out.println();

			// Printing horizontal dividers between the rows
			System.out.print("+");
			for (int j = 0; j < gameboard[i].length; j++) {
				System.out.print("---+");
			}
			System.out.println();
		}
		System.out.println();
	}

	public List<int[]> getFreeCells() {
		List<int[]> freeCells = new ArrayList<>();
		// Collecting the coordinates of all free cells on the board
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (gameboard[i][j] == ' ') {
					freeCells.add(new int[] { i + 1, j + 1 });
				}
			}
		}
		return freeCells;
	}

	public PlayerType getTurn() {
		// Return the current player's type
		return currentPlayer;
	}

	public char[][] getGameboard() {
		// Return the current state of the gameboard
		return gameboard;
	}

	// Abstract methods that need to be implemented in the concrete subclasses
	public abstract boolean isBoardFull();

	public abstract boolean isGameOver();

	public abstract void play(Player p);

}
