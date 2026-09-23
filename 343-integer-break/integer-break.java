class Solution {
    public int helper(int n,int[] dp){
        if(n==1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int prod=1;
        int ans=Integer.MIN_VALUE;
        for(int i=1; i<n; i++){
            
            prod=i*Math.max(n-i,helper(n-i,dp));
            ans=Math.max(ans,prod);
        }
        return dp[n]=ans;
    }
    public int integerBreak(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,dp);
    }
}