class Solution {
    public double helper(int n, int k, int i, int j,double[][][] dp){
        if(i<0 || i>=n || j<0 || j>=n){
            return 0;
        }else{
            if(k==0){
                return 1;
            }
        }
        if(dp[i][j][k]!=-1){
            return dp[i][j][k];
        }
        double upR=helper(n,k-1,i-2,j+1,dp);
        double upl=helper(n,k-1,i-2,j-1,dp);
        double upRl=helper(n,k-1,i-1,j+2,dp);
        double upRr=helper(n,k-1,i+1,j+2,dp);
        double downR=helper(n,k-1,i+2,j+1,dp);
        double downL=helper(n,k-1,i+2,j-1,dp);
        double leftUp=helper(n,k-1,i-1,j-2,dp);
        double leftD=helper(n,k-1,i+1,j-2,dp);
        return dp[i][j][k]=(double) (upR+upl+upRl+upRr+downR+downL+leftUp+leftD)/8.0;
    }
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp= new double[n][n][k+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int x = 0; x <= k; x++) {
                    dp[i][j][x] = -1;
                }
            }
        }
       return helper(n,k,row,column,dp);
    }
}