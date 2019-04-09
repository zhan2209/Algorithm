/*
 * 找出一个字符串中的每个单词的首字母出现的次数, 然后按顺序输出 ex. "My mom is a teacher" "a:1 i:1 m:2 t:1" 
 * 字母频率并且按照出现顺序打印,还是挺简单的 先用 hashmap 统计频率 再用 hashset 确定打印按照出现顺序
 * (Common character, 把一个 string 里面的最高频的字符和最低频的字符互换)
 */

import java.util.*;

public class CharFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(charFrequency("My mom is a teacher"));
	}
	
	public static List<String> charFrequency(String input) {
		List<String> rst = new ArrayList<>();
		if (input == null)
			return rst;
		
		input = input.trim().toLowerCase(); // can use split as well
		Map<Character, Integer> map = new HashMap<>();
		map.put(input.charAt(0), 1);
		for (int i = 1; i < input.length() - 1; i++) {
			 if (input.charAt(i) != ' ')
				 continue;
			 char next = input.charAt(i + 1);
			 if (map.containsKey(next)) {
				 map.put(next, map.get(next) + 1);
			 } else {
				 map.put(next, 1);
			 }
		}
		
		for (char ch = 'a'; ch <= 'z'; ch++) {
			if (map.containsKey(ch))
				rst.add(ch + ":" + map.get(ch));
		}
		return rst;
	}

}
