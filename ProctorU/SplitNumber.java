
public class SplitNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num = "1234567890";
		int[] split = {3,4,2,1};
		System.out.println(splitNumber(num, split));
	}

	public static String splitNumber(String num, int[] split) {
		if (num == null || num.length() == 0 || split == null || split.length == 0) // unable to split
			throw new NullPointerException();

		StringBuilder sb = new StringBuilder();
		int last = num.length();
		for (int i = 0; i < split.length; i++) {
			int len = split[i];
			if (last - len < 0)
				throw new IndexOutOfBoundsException(); // digits less than split
			sb.append(num.substring(last - len, last) + "-");
			last -= len;
		}

		if (last > 0)
			throw new IllegalArgumentException(); // digits more than split
		sb.deleteCharAt(sb.length() - 1); // extra '-'
		return sb.toString();
	}

}
