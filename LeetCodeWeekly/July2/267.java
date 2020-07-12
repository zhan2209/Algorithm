class Solution {
    public List<String> generatePalindromes(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int cnt = 0;
        char x = ' ';
        for(Map.Entry<Character, Integer> e : map.entrySet()){
            if((e.getValue() & 1) == 1){
                x = e.getKey();
                cnt++;
            }
            if(cnt > 1) return Collections.emptyList();
        }
        char[] cc = new char[s.length()];
        int mid = s.length() / 2;
        if(cnt == 1){
            cc[mid] = x;
        }
        Set<String> ans = new HashSet<>();
        dfs(cc, 0, cc.length - 1, map, ans);
        return new ArrayList<>(ans);
    }

    private void dfs(char[] cc, int start, int end, Map<Character, Integer> map, Set<String> ans){
        if(start >= end){
            ans.add(String.valueOf(cc));
            return;
        }
        for(Map.Entry<Character, Integer> e : map.entrySet()){
            if(e.getValue() >= 2){
                cc[start] = e.getKey();
                cc[end] = e.getKey();
                map.put(e.getKey(), e.getValue() - 2);
                dfs(cc, start + 1, end - 1, map, ans);
                map.put(e.getKey(), e.getValue() + 2);
            }
        }
    }
}