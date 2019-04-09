/*
 * There is a security keypad at the entrance of a building. It has 9 numbers 1 - 9 in a 3x3 matrix format.
		123
		456
		789
 * The security has decided to allow one digit error for a person but that digit should be horizontal or vertical. 
 * Example: for 5 the user is allowed to enter 2, 4, 6, 8 or for 4 the user is allowed to enter 1, 5, 7. 
 * IF the security code to enter is 1478 and if the user enters 1178 he should be allowed. Write a function to take 
 * security code from the user and print out if he should be allowed or not.
 */

public class SecurityKeypad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(keypad("1478","1178"));
		System.out.println(keypad("1478","1128"));
		System.out.println(keypad("1478","1378"));
	}
	
	public static boolean keypad(String key, String input) {
		if (key == null || input == null)
			return key == null && input == null;
		if (key.length() == 0 || input.length() == 0)
			return key.length() == 0 && input.length() == 0;
		if (key.length() != input.length())
			return false;
		
		char[][] grid = { { '1','2','3' },{ '4','5','6' },{ '7','8','9' } };
		int count = 0;
		for (int i = 0; i < key.length(); i++) {
			if (key.charAt(i) == input.charAt(i))
				continue;
			int num = input.charAt(i) - '0';
			if (!validSurround(grid, (num - 1) / 3, (num - 1) % 3, key.charAt(i))) 
				return false;
			count++; // not match but valid error
			if (count > 1) 
				return false;
		}
		return true;
	}
	
	private static boolean validSurround(char[][] grid, int row, int col, char key) {
		if ((row > 0 && grid[row - 1][col] == key) || (col > 0 && grid[row][col - 1] == key)
				|| (row < grid.length - 1 && grid[row + 1][col] == key)
				|| (col < grid[0].length - 1 && grid[row][col + 1] == key))
			return true;
		return false;
	}

}
