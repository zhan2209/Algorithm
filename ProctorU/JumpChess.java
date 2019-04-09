/*
 * There’s a N*N board, two players join the jump game. The chess could go vertically and horizontally. If the adjacent 
 * chess is opponent player’s and the spot beside that is empty, then the chess could jump to that spot. One chess 
 * could not been jumped twice. Given the position of the spot on the board, write the program to count the longest 
 * length that chess could go.
 */

public class JumpChess {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { 
				{0, 1, 2, 0, 0},
				{0, 2, 0, 2, 0},
				{0, 0, 2, 0, 2},
				{0, 1, 0, 2, 0},
				{0, 0, 1, 0, 1} };
		System.out.println(longestLength(matrix, 0, 1));
	}
	
	public static int longestLength(int[][] grid, int row, int col) {
		if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
			throw new NullPointerException();
		if (grid[row][col] == 0)
			throw new IllegalArgumentException();
		
		int[][] direction = { { -1,0,-2,0 },{ 1,0,2,0 },{ 0,-1,0,-2 },{ 0,1,0,2 } };
		int maxLen = dfs(grid, row, col, 0, 0, direction);
		return maxLen;
	}
	
	private static int dfs(int[][] grid, int row, int col, int maxLen, int len, int[][] direction) {
		for (int i = 0; i < direction.length; i++) {
			int jumpRow = row + direction[i][2], jumpCol = col + direction[i][3];
			int neighRow = row + direction[i][0], neighCol = col + direction[i][1];
			// *IMPORTANT* -- how to *MARK* the chess to prevent jumping cross twice
			
			if (valid(grid, jumpRow, jumpCol) && canJump(grid[neighRow][neighCol], grid[row][col])) {
				grid[jumpRow][jumpCol] = grid[row][col];
				int tmp = grid[neighRow][neighCol];
				grid[neighRow][neighCol] = -1; // cannot be jumped twice
				// need to compare *ALL* of current max, new length, and recursive max
				maxLen = Math.max(Math.max(maxLen, len + 1), dfs(grid, jumpRow, jumpCol, maxLen, len + 1, direction));
				grid[neighRow][neighCol] = tmp;
				grid[jumpRow][jumpCol] = 0;
			}
		}
		return maxLen;	
	}
	
	private static boolean valid(int[][] grid, int row, int col) {
		return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 0;
	}
	
	private static boolean canJump(int next, int curr) {
		return next != 0 && next != -1 && curr != 0 && curr != -1 && next != curr;
	}
	
}
