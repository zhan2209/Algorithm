class Solution {
    public int minCost(int[][] costs) {
        int length = costs.length;
        if(length == 0){
            return 0;
        }
        
        int[][] dp = new int[length][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        int i = 1;
        for(; i < length; i++){
            int index = i - 1;
            dp[i][0] = Math.min(dp[index][1], dp[index][2])+
                costs[i][0];
            dp[i][1] = Math.min(dp[index][0], dp[index][2])+
                costs[i][1];
            dp[i][2] = Math.min(dp[index][0], dp[index][1])+
                costs[i][2];
        }
        
        return Math.min(Math.min(dp[i - 1][0], dp[i - 1][1]), 
                       dp[i -1][2]);
    }
}