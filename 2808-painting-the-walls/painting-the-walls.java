class Solution {
    public int helper(int[] cost, int[] time, int i, int remain,int [][] dp){
        if(remain<=0){
            return 0; 
        }
            
        if(i>=cost.length){
            return 1000000000;
        }
        if(dp[i][remain]!=-1){
            return dp[i][remain];
        }
        

        int paid=cost[i]+helper(cost,time,i+1,remain-1-time[i],dp);
        int free=helper(cost,time,i+1,remain,dp);
        return dp[i][remain]= Math.min(paid,free);
    }
    public int paintWalls(int[] cost, int[] time) {
        int n=cost.length;
        int[][] dp= new int[n][n+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return helper(cost,time,0,n,dp);
    }
}