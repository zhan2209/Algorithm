/*
 * Find the presence of a given word in a given grid, word can be matched in any direction up-down, down-up, 
 * left-right, right-left, both diagonals up and down etc.
 * Word Search,要找八个方向,与 leetcode 原题相似: 给一个 matrix,每个 grid 里面是一个 letter,然后给一个 word,找这个 word 是不是在这个
 * matrix 里面,如果找到就打印坐标,8 个方向都要找
 */

public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = {
				{'A','B','C','D','E'},
				{'F','G','H','J','K'},
				{'L','M','N','O','P'},
				{'Q','R','S','T','U'},
				{'V','W','X','Y','Z'}
		};
		System.out.println(wordSearch(grid, "OSTP"));
		System.out.println(wordSearch(grid, "HMNM"));
	}
	
	public static boolean wordSearch(char[][] grid, String word) {
		if (word == null || word.length() == 0)
			return true;
		if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
			return false;
		
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (grid[row][col] == word.charAt(0)) {
					if (dfs(grid, row, col, word, 0))
						return true;
				}
			}
		}
		return false;
	}
	
	private static boolean dfs(char[][] grid, int row, int col, String word, int curr) {
		if (curr == word.length())
			return true;
		if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) 
			return false;
		if (grid[row][col] != word.charAt(curr))
			return false;
		
		grid[row][col] = '#';
		boolean rst = dfs(grid, row - 1, col, word, curr + 1) || dfs(grid, row + 1, col, word, curr + 1) ||
				dfs(grid, row, col - 1, word, curr + 1) || dfs(grid, row, col + 1, word, curr + 1) ||
				dfs(grid, row - 1, col - 1, word, curr + 1) || dfs(grid, row - 1, col + 1, word, curr + 1) ||
				dfs(grid, row + 1, col - 1, word, curr + 1) || dfs(grid, row + 1, col + 1, word, curr + 1);
		grid[row][col] = word.charAt(curr);
		return rst;
	}

}
