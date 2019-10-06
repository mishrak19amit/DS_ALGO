package org.amit.backtracking;

public class NQueen {
	final int N = 6;

	public static void main(String[] args) {
		NQueen Queen = new NQueen();
		Queen.solveNQ();
	}

	private boolean solveNQ() {
		int board[][] = { { 0, 0, 0, 0 ,0,0}, { 0, 0, 0, 0 ,0,0}, { 0, 0, 0, 0 ,0,0}, { 0, 0, 0, 0 ,0,0}, { 0, 0, 0, 0 ,0,0}, { 0, 0, 0, 0 ,0,0} };

		if (solveNQUtil(board, 0) == false) {
			System.out.print("Solution does not exist");
			return false;
		}

		printSolution(board);
		return true;

	}

	private boolean solveNQUtil(int[][] board, int col) {

		if (N <= col) {
			return true;
		}
		for (int i = 0; i < N; i++) {
			if (isSafe(board, i, col)) {

				board[i][col] = 1;
				if (solveNQUtil(board, col + 1)) {
					return true;
				}
				board[i][col] = 0;
			}
		}

		return false;
	}

	private boolean isSafe(int[][] board, int row, int col) {

		for (int i = 0; i < col; i++) {
			if (board[row][i] == 1)
				return false;
		}

		for (int i = row, j = col; i < N && 0 <= j; j--, i++) {
			if (board[i][j] == 1)
				return false;
		}

		for (int i = row, j = col; 0 <= i && 0 <= j; i--, j--) {

			if (board[i][j] == 1)
				return false;
		}

		return true;
	}

	void printSolution(int board[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(" " + board[i][j] + " ");
			System.out.println();
		}
	}

}
