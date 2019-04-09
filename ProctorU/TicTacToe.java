/*
 * N*N matrix is given with input red or black. You can move horizontally, vertically or diagonally. If 3 consecutive 
 * same colors found, that color will get 1 point. So if 4 red are vertically then point is 2. Find the winner.
 */

public class TicTacToe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = { 
				{ 'r', 'r', 'r', 'b' }, 
				{ 'b', 'r', 'b', 'r' },
				{ 'b', 'r', 'r', 'b' }, 
				{ 'b', 'r', 'b', 'b' } 
			};
		System.out.println(ticTacToe(matrix));
	}

	// start from the most top and the most left
	public static String ticTacToe(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
			return "Invalid input and cannot find winner!";
		int countR = 0, countB = 0;
		int[][] direction = {{0,1,0,2},{1,0,2,0},{1,1,2,2},{-1,1,-2,2}};
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (grid[row][col] == ' ')
					continue;
				char curr = grid[row][col];
				for (int i = 0; i < direction.length; i++) {
					int row1 = row + direction[i][0], col1 = col + direction[i][1];
					int row2 = row + direction[i][2], col2 = col + direction[i][3];
					if (valid(grid, row2, col2) && curr == grid[row1][col1] && curr == grid[row2][col2]) {
						if (curr == 'r') {
							countR++;
						} else {
							countB++;
						}
					}
				}
			}
		}

		// System.out.println(countR + "   " + countB);
		if (countR < countB)
			return "Black wins!";
		if (countR > countB)
			return "Red wins!";
		return "Break even!";
	}
	
	private static boolean valid(char[][] grid, int row, int col) {
		return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
	}
}
