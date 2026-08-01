class Solution {
    public int helper(int st,int n,int[] dp){
        if(st==n){
            return 1;
        }
        if(st>n) return 0;
        if(dp[st]!=-1) return dp[st];
        int take=helper(st+1,n,dp);
        int skipOneStair=helper(st+2,n,dp);
        return dp[st]=take+skipOneStair;
    }
    public int climbStairs(int n) {
        int[] dp= new int[n];
        Arrays.fill(dp,-1);
       return helper(0,n,dp);
    }
}