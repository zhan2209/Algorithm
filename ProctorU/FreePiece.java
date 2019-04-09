/*
 * 大概说是你和朋友下棋,你碰掉了一个棋子,俩人都不知道原来放哪的,朋友说你可以随便摆回去。输入一个二维矩阵,0 表示空位,1 表示自己的棋子,2 表示对手的。
 * 然后棋子吃子的原则是能横着或竖着走,不能对角线,不能跨棋子,碰到对手就能“capture”。问找一个点能“capture”最多对手棋子的点。
 */

public class FreePiece {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	public static int mostCapture(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
			return 0;
		
		int max = 0;
		int mostCapRow = -1, mostCapCol = -1;
		int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (grid[row][col] != 0) {
					int capture = dfs(grid, row, col, direction, 0, grid[row][col]);
					if (capture > max) {
						mostCapRow = row;
						mostCapCol = col;
						max = capture;
					}
				}
			}
		}
		return max;
	}
	
	private static int dfs(int[][]grid, int row, int col, int[][] direction, int count, int curr) {
		if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length)
			return 0;
		if (grid[row][col] == curr) 
			return 0;
		if 
		
	}
	*/

}
