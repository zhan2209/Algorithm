
class Solution {
    public int minimumMoves(int[] arr) {
        int len = arr.length;
        int[][] count = new int[len][len];
        for(int i=0;i<len;i++){
            for(int j=i;j>=0;j--){
                if(i==j){
                    count[j][i] = 1;
                }else{
                    if(arr[j]==arr[i]){
                        if(i-j==1){
                            count[j][i] = 1;
                        }else{
                            count[j][i] = count[j+1][i-1];
                        }
                    }else {
                        count[j][i] = Integer.MAX_VALUE;
                    }
                    for(int k=j;k<i;k++){
                        count[j][i] = Math.min(count[j][i],count[j][k]+count[k+1][i]);
                    }
                }
            }
        }
        return count[0][len-1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumMoves(new int[]{1, 4, 1, 1, 2, 3, 2, 1}));
    }
}
