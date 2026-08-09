class Solution {
    public int helper(int length,int low, int high, int zero, int one,int[] dp){
        if(length>high){
            return 0;
        }
        if(dp[length]!=-1){
            return dp[length];
        }
        int ans=0;
        if(length>=low && length<=high){
            ans=1;
        }
        int take1=helper(length+one,low,high,zero,one,dp);
        int take0=helper(length+zero,low,high,zero,one,dp);
        return dp[length]= (ans+take1+take0)%1000000007;
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp= new int[high+1];
        Arrays.fill(dp,-1);
        return helper(0,low,high,zero,one,dp);
    }
}