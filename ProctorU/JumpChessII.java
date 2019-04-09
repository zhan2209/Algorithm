/*
 * N*N matrix, find the longest ways for **EACH** players. Players: red and blue.
 * Players can jump to the next position based on the opposite player, after jump, remove the opposite player.
 * jump game 一个 matrix 上面存 0,1,2. 0 代表 empty, 1 代表 player 1 占据了这个格子, 2 代表 player 2 占据了这个格子
 * jump 的规则是只能 horizontal 或者 vertical, 相邻的必须是对方的棋子, 跳到对方棋子的另一边,跳的落点必须是空。
 * 例子:		01011
 * 			02002 
 * 			00102 
 * 			00000
 * m[0][1]出发的话 只能超下跳一步,然后 m[2][1]被 1 占据。最后要找出最长的 path 的 length
 */

public class JumpChessII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// *IMPORTANT* to compare with the condition and code with "Jump Chess"
	public static void jumpChess(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
			throw new NullPointerException();
		
		int maxLen1 = 0, maxLen2 = 0;
		int[][] direction = { { 0,1,0,2 },{ 0,-1,0,-2 },{ 1,0,2,0 },{ -1,0,-2,0 } };
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (grid[row][col] == 1) {					
					maxLen1 = Math.max(maxLen1, dfs(grid, row, col, direction, 0));
				} else if (grid[row][col] == 2) {
					maxLen2 = Math.max(maxLen2, dfs(grid, row, col, direction, 0));
				}
			}
		}
		System.out.println("The longest paths for player 1 is " + maxLen1);
		System.out.println("The longest paths for player 2 is " + maxLen2);
	}
	
	private static int dfs(int[][] grid, int row, int col, int[][] direction, int len) {
		int max = 0;
		for (int i = 0; i < direction.length; i++) {
			int jumpToRow = row + direction[i][2], jumpToCol = col + direction[i][3];
			int neighborRow = row + direction[i][0], neighborCol = col + direction[i][1];
			int curr = grid[row][col];
			
			if (canJump(grid, jumpToRow, jumpToCol) && valid(grid[neighborRow][neighborCol], curr)) {
				grid[jumpToRow][jumpToCol] = curr;
				grid[row][col] = 0; // after jumping, the original place is *EMPTY*
				int tmp = grid[neighborRow][neighborCol];
				grid[neighborRow][neighborCol] = 0;
				
				max = Math.max(Math.max(max, len + 1), dfs(grid, jumpToRow, jumpToRow, direction, len + 1)); 
				
				grid[neighborRow][neighborCol] = tmp;
				grid[row][col] = grid[jumpToRow][jumpToCol];
				grid[jumpToRow][jumpToCol] = 0;
			}
		}
		return max;
	}
	
	private static boolean canJump(int[][] grid, int row, int col) {
		return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 0;
	}
	
	private static boolean valid(int next, int curr) {
		return curr != 0 && next != 0 && curr != next;
	}

}
