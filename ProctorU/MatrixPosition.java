/*
 * Given an NxN matrix with unique integers: Find and print positions of all numbers such that it is the biggest in 
 * its row and also the smallest in its column . 
 * e.g. : In 3 x 3 with elements, 	123
									456
									789
 * the number is 3 and position (1,3)
 */

import java.util.*;

public class MatrixPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
				{1, 2, 3}, 
				{4, 5, 6},
				{7, 8, 9} 	
			};
		System.out.println(matrixPosition(matrix));
	}

	public static List<String> matrixPosition(int[][] grid) {
		List<String> rst = new ArrayList<>();
		if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
			return rst;
		Map<Integer, Integer> map = new HashMap<>();
		int row = grid.length, col = grid[0].length;
		
		for (int i = 0; i < row; i++) {
			int max = grid[i][0];
			int x = i + 1, y = 1; // index VS position
			for (int j = 1; j < col; j++) {
				if (grid[i][j] > max) {
					max = grid[i][j];
					y = j + 1;
				}
			}
			map.put(x, y);
		}
		
		for (int j = 0; j < col; j++) {
			int min = grid[0][j];
			int x = 1, y = j + 1;
			for (int i = 1; i < row; i++) {
				if (grid[i][j] < min) {
					min = grid[i][j];
					x = i + 1;
				}
			}
			if (map.containsKey(x) && map.get(x) == y) 
				rst.add("("  + x + "," + y + ")");
		}
		return rst;
	}
}
