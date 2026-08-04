class Solution {
    public int helper(int n,int[] dp ){
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int ans=Integer.MAX_VALUE;
        int result=0;
        
        for(int i=1;i*i<=n; i++){
            result=1+helper(n-i*i,dp);
            ans=Math.min(ans,result);
        }
        return dp[n]= ans;
    }
    public int numSquares(int n) {
        int[] dp = new int[10001];
        Arrays.fill(dp,-1);
        return helper(n,dp);
        
    }
}