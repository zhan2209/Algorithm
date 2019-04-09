/*
 * Write a program for a word search. If there is an NxN grid with one letter in each cell. Let the user enter a word 
 * and the letters of the word are said to be found in the grid either the letters match vertically, horizontally or 
 * diagonally in the grid. If the word is found, print the coordinates of the letters as output.
 */

import java.util.*;

public class FindingWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 		char[][] board = {
			{ 'l', 'a', 'c', 'd' }, 
			{ 'e', 'f', 'g', 'h' },
			{ 'i', 'j', 'a', 'l' }, 
			{ 'm', 'n', 'o', 'p' } 
		};
 		System.out.println(findWord(board, "al"));
	}
	
	public static Set<List<String>> findWord(char[][] grid, String word) {
		Set<List<String>> rst = new HashSet<>();
		if (word == null || word.length() == 0)
			return rst;
		if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
			return rst;
		
		int[][] direction = { { -1,0 },{ 1,0 },{ 0,-1 },{ 0,1 },{ -1,-1 },{ -1,1 },{ 1,-1 },{ 1,1 } };
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (grid[row][col] == word.charAt(0)) {
					dfs(rst, grid, word, 0, row, col, new ArrayList<String>(), direction);
				}
			}
		}
		return rst;
	}
	
	private static void dfs(Set<List<String>> rst, char[][] grid, String word, int curr, 
			int row, int col, List<String> list, int[][] direction) {
		if (curr == word.length()) {
			rst.add(new ArrayList<>(list));
			return;
		}
		if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length)
			return;
		if (grid[row][col] != word.charAt(curr))
			return;
		
		grid[row][col] = '#';
		list.add("(" + row + "," + col + ")");
		for (int i = 0; i < direction.length; i++) {
			dfs(rst, grid, word, curr + 1, row + direction[i][0], col + direction[i][1], list, direction);
		}
		list.remove(list.size() - 1);
		grid[row][col] = word.charAt(curr);
	}
}
