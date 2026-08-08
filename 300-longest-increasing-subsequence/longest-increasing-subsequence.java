class Solution {
    public int helper(int st,int prev,int[] nums,int[][] dp){
        if(st>=nums.length){
            return 0;
        }
        if(dp[st][prev+1]!=-1){
            return dp[st][prev+1];
        }
        int take=0;
        if(prev==-1 || nums[prev]<nums[st]){
           take =1+helper(st+1,st,nums,dp);
        }
        int skip=helper(st+1,prev,nums,dp);
        return dp[st][prev+1]= Math.max(take,skip);
    }
    public int lengthOfLIS(int[] nums) {
        int n= nums.length;
        int[][] dp= new int[n][n+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                dp[i][j]=-1;
            }
        }
        return helper(0,-1,nums,dp);
    }
}