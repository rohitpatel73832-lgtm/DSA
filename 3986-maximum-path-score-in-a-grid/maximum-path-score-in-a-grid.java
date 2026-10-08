class Solution {
    public int helper(int i, int j, int[][] grid, int k, int[][][] dp) {

        if(i >= grid.length || j >= grid[0].length) {
            return -1;
        }

        int cost = 0;

        if(grid[i][j] == 1 || grid[i][j] == 2) {
            cost = 1;
        }

        if(k - cost < 0) {
            return -1;
        }

        if(dp[i][j][k] != -2) {
            return dp[i][j][k];
        }

        if(i == grid.length - 1 && j == grid[0].length - 1) {
            return dp[i][j][k] = grid[i][j];
        }

        int right = helper(i, j + 1, grid, k - cost, dp);
        int down = helper(i + 1, j, grid, k - cost, dp);

        if(right == -1 && down == -1) {
            return dp[i][j][k] = -1;
        }

        return dp[i][j][k] = grid[i][j] + Math.max(right, down);
    }

    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][k + 1];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -2);
            }
        }

        return helper(0, 0, grid, k, dp);
    }
}