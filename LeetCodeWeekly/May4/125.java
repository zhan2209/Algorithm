class Solution {
    public boolean isPalindrome(String s) {
        String inputNew = s.toLowerCase();
        String input = inputNew.replaceAll("[^A-Za-z0-9]", "");
        
        
        for(int i = 0, j = input.length() - 1; i<j;i++,j--){    
            if(input.charAt(i) != input.charAt(j)){
                return false;
            }
        }
        
        return true;
    }
}
// remove all non-letters, then compare head-> vs <-end