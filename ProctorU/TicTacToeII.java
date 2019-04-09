/*
 * Tic tac toe II
 * N*N matrix, two users: X and O. If 3 respective marks together (no matter: vertical, horizontal, diagonal) will 
 * win 1 point; for user X, 6 respective marks together will win 3 points; For user O, 8 respective marks together 
 * will win 6 points, check who win.
 */

public class TicTacToeII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void ticTacToe(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
			return;
		
		// from top left to bottom right
		int[][] direction = {{1,0,2,0},{0,1,0,2},{1,1,2,2},{1,-1,2,-2}};
		int countX = 0, countO = 0;
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (grid[row][col] == ' ')
					continue;
				char curr = grid[row][col];
				for (int i = 0; i < direction.length; i++) {
					int row1 = row + direction[i][0], col1 = col + direction[i][1];
					int row2 = row + direction[i][2], col2 = col + direction[i][3];
					if (valid(grid, row2, col2) && curr == grid[row1][col1] && curr == grid[row2][col2]) {
						if (curr == 'X') {
							countX++;
						} else {
							countO++;
						}
					}
				}
			}
		}
		int scoreX = countX / 3 + countX / 6 * 3;
		int scoreO = countO / 3 + countO / 8 * 6;
		if (scoreX == scoreO) {
			System.out.println("Player X and player O have the same scores.");
		} else if (scoreX > scoreO) {
			System.out.println("Player X wins.");
		} else {
			System.out.println("Player O wins.");
		}
	}
	
	private static boolean valid(char[][] grid, int row, int col) {
		return row >=0 && row < grid.length && col >= 0 && col < grid[0].length;
	}

}
