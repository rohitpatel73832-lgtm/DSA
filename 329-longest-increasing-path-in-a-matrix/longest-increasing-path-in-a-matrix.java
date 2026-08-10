class Solution {
    public int helper(int sr, int sc, int er, int ec, int[][] matrix,int[][] dp){
        if (dp[sr][sc] != 0) {
            return dp[sr][sc];
        }
        int right=0;
        int left=0;
        int down=0;
        int up=0;
        if (sc + 1 < ec && matrix[sr][sc + 1] > matrix[sr][sc]) {
            right =1+ helper(sr, sc + 1, er, ec, matrix,dp);
        }

        // move left
        if (sc - 1 >= 0 && matrix[sr][sc - 1] > matrix[sr][sc]) {
            left =1+ helper(sr, sc - 1, er, ec, matrix,dp);
        }

        // move down
        if (sr + 1 < er && matrix[sr + 1][sc] > matrix[sr][sc]) {
            down = 1+ helper(sr + 1, sc, er, ec, matrix,dp);
        }

        // move up
        if (sr - 1 >= 0 && matrix[sr - 1][sc] > matrix[sr][sc]) {
            up = 1+ helper(sr - 1, sc, er, ec, matrix,dp);
        }

        int a = Math.max(right, left);
        int b = Math.max(up, down);
        if (a == 0 && b == 0) {
            return dp[sr][sc] = 1;
        }

        return dp[sr][sc]=  Math.max(a, b);
    }
    public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int ans = 0;
        int[][] dp = new int[m][n];

        // Start from every cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, helper(i, j, m, n, matrix,dp));
                                                   
            }
        }

        return ans;
    }
}