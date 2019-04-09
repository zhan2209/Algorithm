/*
 * Given a M * N matrix, if the element in the matrix is larger than other 8 elements who stay around it, then named 
 * that element be mountain point. Print all the mountain points.
 */

import java.util.*;

public class MountainPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {
				{1, 1, 2, 3, 1}, 
				{1, 9, 8, 9, 5},
				{1, 1, 4, 1, 6}
		};
		System.out.println(mountainPoint(grid));
	}
	
	public static List<String> mountainPoint(int[][] grid) {
		List<String> rst = new ArrayList<>();
		if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
			return rst;
		
		int row = grid.length, col = grid[0].length;
		if (row * col < 8)
			return rst;
		
		for (int i = 1; i < row - 1; i++) {
			for (int j = 1; j < col - 1; j++) {
				if (isMountainPoint(grid, i, j))
					rst.add("(" + i + "," + j + ")");
			}
		}
		return rst;
	}
	
	private static boolean isMountainPoint(int[][] grid, int row, int col) {
		for (int i = row - 1; i <= row + 1; i++) {
			for (int j = col - 1; j <= col + 1; j++) {
				if (i == row && j == col) 
					continue;
				if (grid[i][j] >= grid[row][col])
					return false;
			}
		}
		return true;
	}

}
