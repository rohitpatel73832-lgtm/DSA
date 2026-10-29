class Solution {
    public int helper(int sr,int sc,int m,int n,int[][] dp){
        if(sr>=m || sc>=n) return 0;
        if(sr==m-1 && sc==n-1){
            return 1;
        }
        if(dp[sr][sc]!=-1) return dp[sr][sc];
        
            int down=helper(sr+1,sc,m,n,dp);
        
        
            int right=helper(sr,sc+1,m,n,dp);
        
        return dp[sr][sc]=down+right;
        
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

       for(int i=0;i<m;i++){
          for(int j=0;j<n;j++){
            dp[i][j] = -1;
          }
       }

       return helper(0,0,m,n,dp);
    }
}