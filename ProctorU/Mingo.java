/*
 * A random generator (like a speaker standing in a group housie game calls out a number) generates out any number 
 * from 1 to 1000. There is a 10X10 matrix. A random generator assigns values to each block of this matrix (within 
 * 1 to 1000 obviously). Whenever, a row or a column or a diagonal is fully filled in this 10x10 from the numbers 
 * called out by the speaker, its called a 'Mingo'. Write a program that will find first Mingo, then second Mingo, 
 * then thirds Mingo...and so forth.
 */

import java.util.*;

/*
// method 1: count left/right diagonals separately
public class Mingo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mingo());
	}
	
	public static List<String> mingo() {
		List<String> rst = new ArrayList<>();
		Random rand = new Random();
		int[][] grid = new int[10][10];
		int count = 0;
		int filled = 0;
		
		while (filled < 100) {
			int curr = rand.nextInt(1000) + 1;
			int row = rand.nextInt(10);
			int col = rand.nextInt(10);
			
			if (grid[row][col] != 0)
				continue;
			grid[row][col] = curr;
			filled++;
			
			boolean isMingoRow = true;
			boolean isMingoCol = true;
			boolean isMingoDiagL = true;
			boolean isMingoDiagR = true;
			
			for (int idx = 0; idx < 10; idx++) {
				if (grid[row][idx] == 0) {
					isMingoRow = false;
					break;
				}
				if (grid[idx][col] == 0) {
					isMingoCol = false;
					break;
				}
				if ((valid(row - idx, col - idx) && grid[row - idx][col - idx] == 0) ||
						valid(idx - row, idx - col) && grid[idx - row][idx - col] == 0) {
					isMingoDiagL = true;
					break;
				}
				if ((valid(row - idx, idx - col) && grid[row - idx][idx - col] == 0) ||
						valid(idx - row, col - idx) && grid[idx - row][col - idx] == 0) {
					isMingoDiagR = true;
					break;
				}
			}
			
			if (isMingoRow || isMingoCol || isMingoDiagL || isMingoDiagR) {
				count++;
				rst.add("The " + count + " Mingo is at (" + row + "," + col +")");
			}
		}
		return rst;
	}

	private static boolean valid(int row, int col) {
		return row >= 0 && row < 10 && col >= 0 && col < 10;
	}
}
*/

// method 2: count left/right diagonals together
public class Mingo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mingo());
	}
	
	public static List<String> mingo() {
		List<String> rst = new ArrayList<>();
		Random rand = new Random();
		int[][] grid = new int[10][10];
		int count = 0;
		int filled = 0;
		
		while (filled < 100) {
			int curr = rand.nextInt(1000) + 1;
			int row = rand.nextInt(10);
			int col = rand.nextInt(10);
			
			if (grid[row][col] != 0)
				continue;
			grid[row][col] = curr;
			filled++;
			
			boolean isMingoRow = true, isMingoCol = true, isMingoDiag = true;			
			for (int x = 0; x < 10; x++) {
				for (int y = 0; y < 10; y++) {
					if (grid[row][y] == 0) {
						isMingoRow = false;
						break;
					}
					if (grid[x][col] == 0) {
						isMingoCol = false;
						break;
					}
					if (Math.abs(row - x) == Math.abs(col - y) && grid[x][y] == 0) {
						isMingoDiag = false;
						break;
					}
				}
			}
			
			if (isMingoRow || isMingoCol || isMingoDiag) {
				count++;
				rst.add("The " + count + " Mingo is at (" + row + "," + col +")");
			}
		}
		return rst;
	}
}