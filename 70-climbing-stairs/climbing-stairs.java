class Solution {
    public int helper(int n,int[] dp){
        if(n==0 || n==1){
            return 1;
        }
        if(dp[n]!=0){
            return dp[n];
        }

        int take=helper(n-1,dp);
        int skipOneStair=helper(n-2,dp);

        return dp[n]= take+skipOneStair;
    }
    public int climbStairs(int n) {
        int[] dp= new int[n+1];
        
        return helper(n,dp);
        
    }
}