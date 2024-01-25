package XO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class UserGame extends Game {
	public UserGame() {
		super();// Call the constructor of the Game superclass
	}

	@Override
	public boolean isBoardFull() {
		// Check if there are no more free cells on the board
		if (getFreeCells().isEmpty()) {
			System.out.println("board is full.");
			return true;
		}
		return false;
	}

	@Override
	public boolean isGameOver() {
		// Check if the game is over (either board is full or a player has won)
		if (isBoardFull() || checkWin('X') || checkWin('O')) {
			return true;
		}
		return false;
	}

	@Override
	public synchronized void play(Player p) {
		// Game loop for the user-playing game
		while (!isGameOver()) {
			if (currentPlayer == getTurn()) {
				// Check the type of player and perform the corresponding actions
				if (p instanceof SelfPlayer) {
					List<int[]> freeCells = new ArrayList<>();
					freeCells = getFreeCells();
					Random random = new Random();
					int[] randomMove = freeCells.get(random.nextInt(freeCells.size()));
					int row = randomMove[0] - 1;
					int col = randomMove[1] - 1;
					gameboard[row][col] = currentPlayer.name().charAt(0);
					printBoard();
					if (checkWin(currentPlayer.name().charAt(0))) {
						if (currentPlayer.name().charAt(0) == 'X')
							System.out.println("Player 1 won. ");
						if (currentPlayer.name().charAt(0) == 'O')
							System.out.println("Player 2 won. ");
						return;
					} else if (isBoardFull()) {
						System.out.println("Board is full. ");
						return;
					} else {
						changeTurn();
						notify();
					}
				} else {
					Scanner input = new Scanner(System.in);
					List<int[]> freeCells = new ArrayList<>();
					freeCells = getFreeCells();
					System.out.println("Free cells: ");
					for (int[] cell : freeCells) {
						System.out.println("Row: " + (cell[0]) + ", Col: " + cell[1]);
					}
					System.out.print("Please enter the row number of the empty cell you select: ");
					int row = input.nextInt() - 1;
					System.out.print("Please enter the col number of the empty cell you select: ");
					int col = input.nextInt() - 1;
					gameboard[row][col] = currentPlayer.name().charAt(0);
					printBoard();

					if (checkWin(currentPlayer.name().charAt(0))) {
						if (currentPlayer.name().charAt(0) == 'X')
							System.out.println("Player 1 won. ");
						if (currentPlayer.name().charAt(0) == 'O')
							System.out.println("Player 2 won. ");
						return;
					} else if (isBoardFull()) {
						System.out.println("Board is full. ");
						return;
					} else {
						changeTurn();
						notify();
					}
				}
			}
			// Wait for a while before making the next move
			try {
				wait(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	// Switch the current player
	private void changeTurn() {
		currentPlayer = (currentPlayer == PlayerType.X) ? PlayerType.O : PlayerType.X;
	}

	// Check all rows, columns, and diagonals to see if the current player has won
	private boolean checkWin(char typeplayer) {
		for (int row = 0; row < 5; row++) {
			if (checkLine(typeplayer, gameboard[row][0], gameboard[row][1], gameboard[row][2], gameboard[row][3])
					|| checkLine(typeplayer, gameboard[row][1], gameboard[row][2], gameboard[row][3],
							gameboard[row][4])) {
				return true;
			}
		}

		for (int col = 0; col < 5; col++) {
			if (checkLine(typeplayer, gameboard[0][col], gameboard[1][col], gameboard[2][col], gameboard[3][col])
					|| checkLine(typeplayer, gameboard[1][col], gameboard[2][col], gameboard[3][col],
							gameboard[4][col])) {
				return true;
			}
		}
		return checkDiagonalsForWin(typeplayer);
	}

	private boolean checkLine(char typeplayer, char c1, char c2, char c3, char c4) {
		return (c1 == typeplayer && c1 == c2 && c1 == c3 && c1 == c4);
	}

	private boolean checkDiagonalsForWin(char typeplayer) {
		if (checkLine(typeplayer, gameboard[0][0], gameboard[1][1], gameboard[2][2], gameboard[3][3])
				|| checkLine(typeplayer, gameboard[1][1], gameboard[2][2], gameboard[3][3], gameboard[4][4])
				|| checkLine(typeplayer, gameboard[0][1], gameboard[1][2], gameboard[2][3], gameboard[3][4])
				|| checkLine(typeplayer, gameboard[1][0], gameboard[2][1], gameboard[3][2], gameboard[4][3])
				|| checkLine(typeplayer, gameboard[0][4], gameboard[1][3], gameboard[2][2], gameboard[3][1])
				|| checkLine(typeplayer, gameboard[1][3], gameboard[2][2], gameboard[3][1], gameboard[4][0])
				|| checkLine(typeplayer, gameboard[0][3], gameboard[1][2], gameboard[2][1], gameboard[3][0])
				|| checkLine(typeplayer, gameboard[1][4], gameboard[2][3], gameboard[3][2], gameboard[4][1]))
			return true;
		return false;
	}

}