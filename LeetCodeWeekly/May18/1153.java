class Solution {
    public boolean canConvert(String str1, String str2) {
        if(str1 == str2){
            return true;
        }
        
        if(str1.length() != str2.length()){
            return false;
        }
        if(str1.equals(str2) || str1.length()==1)
            return true;
        //s2 has all 26 chars
        Set<Character> set = new HashSet<>();
        for(char c : str2.toCharArray()) 
            set.add(c);
        if(set.size() == 26)
            return false;
        int i=0;
        Map<Character, Character> map = new HashMap<>();
        while(i<str1.length()) {
            if(map.containsKey(str1.charAt(i)) && map.get(str1.charAt(i)) != str2.charAt(i))
                return false;
            map.put(str1.charAt(i), str2.charAt(i));
            i++;
        }
        return true;
    }
}