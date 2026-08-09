class Solution {
    public long helper(int i, int n, int[][] questions,long[] dp){
        if(i>=n){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        long take=0; 
        long skip=0;
        skip=helper(i+1,n,questions,dp);
        take=questions[i][0]+helper(i+questions[i][1]+1,n,questions,dp);
        return dp[i]= Math.max(skip,take);
    }
    public long mostPoints(int[][] questions) {
        int n=questions.length;
        long[] dp= new long[n];
        Arrays.fill(dp,-1);
        return helper(0,n,questions,dp);
    }
}