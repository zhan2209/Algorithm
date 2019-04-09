/*
 * Given a NXN matrix, starting from the upper right corner of the matrix start printing values in a 
 * counter-clockwise fashion.
 * E.g. Consider N = 4
	Matrix= {a, b, c, d,
			 e, f, g, h, 
			 i, j, k, l, 
			 m, n, o, p}
 * Your function should output: dcbaeimnoplhgfjk
 */

import java.util.*;

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = { 
				{'a','b','c','d'},
				{'e','f','g','h'},
				{'i','j','k','l'},
				{'m','n','o','p'}};
		System.out.println(spiralMatrix(matrix));
	}
	
	public static List<Character> spiralMatrix(char[][] matrix) {
		List<Character> rst = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
			return rst;
		
		int rowLen = matrix.length, colLen = matrix[0].length;
		int row = 0, col = matrix[0].length; // need extra one column
		
		while (true) {
			for (int count = 0; count < colLen; count++) {
				rst.add(matrix[row][--col]);
			}
			if (--rowLen == 0)
				break;
			
			for (int count = 0; count < rowLen; count++) {
				rst.add(matrix[++row][col]);
			}
			if (--colLen == 0)
				break;
			
			for (int count = 0; count < colLen; count++) {
				rst.add(matrix[row][++col]);
			}
			if (--rowLen == 0)
				break;
			
			for (int count = 0; count < rowLen; count++) {
				rst.add(matrix[--row][col]);
			}
			if (--colLen == 0)
				break;
		}
		
		return rst;
	}
}
