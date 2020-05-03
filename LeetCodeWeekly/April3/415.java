class Solution {
    public String addStrings(String nums1, String nums2) {
            StringBuilder sb = new StringBuilder();
        
        int i = nums1.length() - 1;
        int j = nums2.length() - 1;
        
        int flag = 0;
        while( i >= 0 || j >= 0){
            if( i >=0 && j >= 0 ){
                sb.append((Character.getNumericValue(nums1.charAt(i)) 
                           + flag 
                           + Character.getNumericValue(nums2.charAt(j))) % 10 );
                flag = ( Character.getNumericValue(nums1.charAt(i)) 
                        + Character.getNumericValue(nums2.charAt(j)) + flag)/10;
                i--;
                j--;
            }
            
            if( i >= 0 && j < 0){
                sb.append((Character.getNumericValue(nums1.charAt(i)) + flag) % 10);
                flag = (flag + Character.getNumericValue(nums1.charAt(i))) / 10;
                i--;
            }
            
            if(i < 0 && j >= 0 ){
                sb.append((Character.getNumericValue(nums2.charAt(j)) + flag) % 10);
                flag = (flag + Character.getNumericValue(nums2.charAt(j))) / 10;
                j--;
            }
            
        }
        if(flag > 0){
            sb.append(flag);
        }
        
        return sb.reverse().toString();
    }
}+