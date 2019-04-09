/*
 * Given a string. Replace the words whose length>=4 and is even, with a space between the two equal halves of the word. 
 * Consider only alphabets for finding the evenness of the word
 * I/P "A person can't walk in this street" 
 * O/P "A per son ca n't wa lk in th is str eet"
 */

public class ReplaceWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(replaceWords("A person can't walk in this street"));
	}

	public static String replaceWords(String str) {
		StringBuilder sb = new StringBuilder();
		if (str == null || str.length() == 0)
			return "";
		String[] split = str.split(" ");

		/*
		// method 1: more complex but less runtime
		for (String s : split) {
			int l = 0, r = s.length() - 1;
			int count = 0;
			while (l <= r) {
				while (l <= r && !Character.isLetter(s.charAt(l))) {
					l++;
				}
				while (l <= r && !Character.isLetter(s.charAt(r))) {
					r--;
				}
				if (l <= r) {
					l++;
					count++;
				}
				if (l <= r) {
					r--;
					count++;
				}
			}
			if (count >= 4 && count % 2 == 0) {
				sb.append(s.substring(0, l));
				sb.append(" " + s.substring(l));
			} else {
				sb.append(s);
			}
			sb.append(" ");
		}
		*/
		
		// method 2: more runtime but easier to deal with
		for (String s : split) {
			int count = 0;
			for (int i = 0; i < s.length(); i++) {
				if (Character.isLetter(s.charAt(i)))
					count++;
			}
			if (count >= 4 && count % 2 == 0) {
				int half = 0;
				int i = 0;
				for (; i < s.length() && half < count / 2; i++) {
					if (Character.isLetter(s.charAt(i))) {
						half++;
					}
					sb.append(s.charAt(i));
				}
				sb.append(" " + s.substring(i));
			} else {
				sb.append(s);
			}
			sb.append(" ");
		}
		
		return sb.toString().trim();
	}
}
