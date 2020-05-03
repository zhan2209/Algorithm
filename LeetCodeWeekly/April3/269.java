public class Solution {
    public String alienOrder(String[] words) {
        HashMap<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
        
        HashMap<Character, Integer> degree = new HashMap<Character, Integer>();
        
        StringBuilder res = new StringBuilder();
        
        for(String temp: words){
        	char[] chars = temp.toCharArray();
        	for(int j = 0; j < chars.length; j++){
                degree.put(chars[j], 0);
            }
        }
        
        for(int i = 0; i < words.length - 1; i++){
            String index = words[i];
            String next = words[i + 1];
            int len = Math.min(index.length(), next.length());
            for(int j = 0; j < len; j++){
                char c1 = index.charAt(j);
                char c2 = next.charAt(j);
                if(c1 != c2){
                    Set<Character> set = new HashSet<Character>();
                    if(map.containsKey(c1))set = map.get(c1);
                    if(!set.contains(c2)){
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    break;
                    
                }else{
                
                    if(j + 1 == next.length() && j + 1 < index.length())
                        return "";
                }
            }
        }
        
        Queue<Character> queue = new LinkedList<Character>();
        for(char temp: degree.keySet()){
            if(degree.get(temp)==0){
                queue.add(temp);
            } 
        }
        while(!queue.isEmpty()){
            char index = queue.remove();
            res.append(index);
            if(map.containsKey(index)){
                for(char c: map.get(index)){
                    degree.put(c, degree.get(c) - 1);
                    if(degree.get(c) == 0)queue.add(c);
                }
            }
        }
        if(res.length() != degree.size())return "";
        return res.toString();
    }
}
