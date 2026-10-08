class Solution {
    public int helper(int i, int j, int[][] coins, int steal,int[][][] dp){
        if(i>=coins.length || j>=coins[0].length){
            return Integer.MIN_VALUE;
        }
        if(dp[i][j][steal]!=Integer.MIN_VALUE){
            return dp[i][j][steal];
        }

        if(i==coins.length-1 && j==coins[0].length-1){
            if(coins[i][j]<0 && steal>0){
                return 0;
            }else{
                return coins[i][j];
            }
        }
        

        
        int take=coins[i][j]+Math.max(helper(i+1,j,coins,steal,dp),helper(i,j+1,coins,steal,dp));
        int skip=Integer.MIN_VALUE;
        if(coins[i][j]<0 && steal>0){
            int skipDown=helper(i+1,j,coins,steal-1,dp);
            int skipRight=helper(i,j+1,coins,steal-1,dp);
            skip=Math.max(skipDown,skipRight);
        }

        return dp[i][j][steal] = Math.max(take,skip);

    }
    public int maximumAmount(int[][] coins) {
        int m=coins.length;
        int n=coins[0].length;
        int[][][] dp= new int[m+1][n+1][3];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<3; k++){
                    dp[i][j][k]=Integer.MIN_VALUE;
                }
            }
        }
        return helper(0,0,coins,2,dp);
    }
}