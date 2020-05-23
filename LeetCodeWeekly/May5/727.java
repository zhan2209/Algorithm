class Solution {
    public String minWindow(String S, String T) {
        int s = 0;
        int t = 0;
        int start = 0, end = 0;
        int min = S.length() + 1;
        while (s < S.length()) {
            if (S.charAt(s) == T.charAt(t)) t++;
            s++;
            
            if (t == T.length()) {
                int right = s;
                
                s--;
                t--;
                while (t >= 0) {
                    if (S.charAt(s) == T.charAt(t)) t--;
                    s--;
                    
                }
                if (min > right - s - 1) {
                    min = right - s - 1;
                    start = s + 1;
                    end = right;
                }
                t = 0;
                s += 2; 
            }
        }
        return min == S.length() + 1? "" : S.substring(start, end);
    }
}