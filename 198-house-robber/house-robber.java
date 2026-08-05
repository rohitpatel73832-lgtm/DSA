class Solution {
    public int helper(int[] nums,int st,int n,int[] dp){
        if(st>=n){
            return 0;
        }
        if(dp[st]!=-1){
            return dp[st];
        }
        int take=0;
        int skip=0;

        take=nums[st]+helper(nums,st+2,n,dp);
        skip =helper(nums,st+1,n,dp);
        return dp[st]=Math.max(take,skip);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return helper(nums,0,n,dp);
    }
}