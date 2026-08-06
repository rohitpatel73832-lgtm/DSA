class Solution {

    public int helper(int sr, int sc, int er, int ec, int[][] grid, int[][] dp) {

        if (sr == er - 1 && sc == ec - 1) {
            return grid[sr][sc];
        }

        if (dp[sr][sc] != -1) {
            return dp[sr][sc];
        }

        // Last column: can only move down
        if (sc == ec - 1) {
            return dp[sr][sc] = grid[sr][sc] + helper(sr + 1, sc, er, ec, grid, dp);
        }

        // Last row: can only move right
        if (sr == er - 1) {
            return dp[sr][sc] = grid[sr][sc] + helper(sr, sc + 1, er, ec, grid, dp);
        }

        int r = grid[sr][sc] + helper(sr, sc + 1, er, ec, grid, dp);
        int d = grid[sr][sc] + helper(sr + 1, sc, er, ec, grid, dp);

        return dp[sr][sc] = Math.min(r, d);
    }

    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(0, 0, m, n, grid, dp);
    }
}