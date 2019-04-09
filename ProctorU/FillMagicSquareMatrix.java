/*
 * A magic square of order n is an arrangement of the numbers from 1 to n^2 in an n by n matrix with each number 
 * occurring exactly once so that each row, each column and each main diagonal has the same sum. Then n should be 
 * an odd number. In the middle cell of the top row, fill number 1. Then go to above row and right column, and fill 
 * following number 2. If it’s out of boundary, go to the opposite row or column. If the next cell is already occupied, 
 * go to the cell below this cell and fill following number. An example of 5*5 grid is like this for the first 9 numbers:
 * 		00180
		05700
		46000
		00003
		00029
 */

import java.util.*;

public class FillMagicSquareMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] rst = fillMatrix(5);
		for (int[] arr : rst) 
			System.out.println(Arrays.toString(arr));
	}

	public static int[][] fillMatrix(int n) {
		if (n <= 0)
			throw new NullPointerException();
		if (n % 2 == 0)
			throw new IllegalArgumentException();

		int[][] rst = new int[n][n];
		int row = 0, col = n / 2;
		for (int curr = 1; curr <= n * n; curr++) {
			while (row == -1 || row >= n || col == -1 || col == n || rst[row][col] != 0) {
				if (row == -1) {
					row = n - 1; // or "row += n"
				}
				if (row >= n) { // row += 2 can be >= n
					row %= n; // or "row -= n"
				}
				if (col == -1) {
					col = n - 1; // or "col += n"
				}
				if (col == n) {
					col = 0; // or "col -= n"
				}
				// need to go back *ONE MORE* step to get *JUST* below the original cell,
				// since the current row and column has been updated by [row--][col++]
				if (rst[row][col] != 0) { 
					row += 2;
					col -= 1;
				}
			}
			rst[row--][col++] = curr; // fill number, then go to top-right
		}
		return rst;
	}
}
