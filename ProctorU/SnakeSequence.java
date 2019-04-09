/*
 * You are given a grid of numbers. A snake sequence is made up of adjacent numbers such that for each number, 
 * the number on the right or the number below it is +1 or -1 its value. For example,
	 1 3 2  6 8
	-9 7 1 -1 2 
	 1 5 0  1 9
 * In this grid, (3, 2, 1, 0, 1) is a snake sequence. Given a grid, find the longest snake sequences and their lengths 
 * (so there can be multiple snake sequences with the maximum length).
 */

import java.util.*;

public class SnakeSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix1 = {
				{1,  3, 2,  6, 8},
				{-9, 7, 1, -1, 2},
				{1,  5, 0,  1, 9}
		};
		int[][] matrix2 = {
				{1, 1, 2, 3, 1},
				{1, 1, 3, 4, 5},
				{1, 1, 4, 1, 6}
		};
		System.out.println(snake(matrix1));
		System.out.println(snake(matrix2));
	}

	// Dynamic Programming
	public static Set<String> snake(int[][] grid) {
		Set<String> rst = new HashSet<>();
		if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
			return rst;

		int row = grid.length, col = grid[0].length;
		int[][] len = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				len[i][j] = 1;
			}
		}

		int maxLen = 1;
		int endRow = 0, endCol = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (i > 0 && Math.abs(grid[i - 1][j] - grid[i][j]) == 1) {
					len[i][j] = Math.max(len[i][j], len[i - 1][j] + 1);
				}
				if (j > 0 && Math.abs(grid[i][j - 1] - grid[i][j]) == 1) {
					len[i][j] = Math.max(len[i][j], len[i][j - 1] + 1);
				}
				if (len[i][j] > maxLen) {
					maxLen = len[i][j];
					endRow = i;
					endCol = j;
				}
			}
		}

		int[][] direction = { { -1,0 },{ 1,0 },{ 0,-1 },{ 0,1 } };
		StringBuilder sb = new StringBuilder();
		sb.append(grid[endRow][endCol]);
		trackSnakeSequence(grid, rst, sb, endRow, endCol, maxLen, direction);
		return rst;
	}

	private static void trackSnakeSequence(int[][]grid, Set<String> rst, StringBuilder sb, 
			int row, int col, int maxLen, int[][] direction) {
		if (sb.length() == maxLen) {
			rst.add(sb.toString()); // *CANNOT* use reverse() at here
			return;
		}

		int curr = grid[row][col];
		grid[row][col] = '#';		
		for (int i = 0; i < direction.length; i++) {
			int newRow = row + direction[i][0];
			int newCol = col + direction[i][1];
			if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
					&& Math.abs(grid[newRow][newCol] - curr) == 1) {
				sb.append(grid[newRow][newCol]);
				trackSnakeSequence(grid, rst, sb, newRow, newCol, maxLen, direction);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
		grid[row][col] = curr;
		
	}
}
