/*
 * Print the sequences from the input given by the user separated by semicolon 
 * e.g.: 4678912356012356	output: 4;6789;123;56;0123;56;
 */

public class SeparateTheNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sequence("4"));
		System.out.println(sequence("456"));
		System.out.println(sequence("479"));
		System.out.println(sequence("4678912356012356"));
	}
	
	// input should be String in case of out of range
	public static String sequence(String num) { 
		if (num == null || num.length() == 0)
			return "";
		
		StringBuilder sb = new StringBuilder();
		for (int idx = 0; idx < num.length(); idx++) {
			if (!Character.isDigit(num.charAt(idx)))
				return "Invalid Input";
			sb.append(num.charAt(idx)); // could append One-By-One instead of Substring
			if (idx + 1 == num.length() || num.charAt(idx + 1) != num.charAt(idx) + 1) {				
				sb.append(";");
			}
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

}
