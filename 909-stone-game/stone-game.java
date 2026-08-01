class Solution {
    public int helper(int i,int j,int[] piles,int[][] dp){
        if(i>j){
            return 0;
        }
        if(i==j){
            return piles[i];
        }
        if (dp[i][j] != Integer.MIN_VALUE) {
            return dp[i][j];
        }
        int takeI=piles[i]-helper(i+1,j,piles,dp);
        int takeJ=piles[j]-helper(i,j-1,piles,dp);
        return dp[i][j]= Math.max(takeI,takeJ);
    }
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        int[][] dp= new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                dp[i][j]=Integer.MIN_VALUE;
            }
        }
        return helper(0,n-1,piles,dp)>=0;
    }
}