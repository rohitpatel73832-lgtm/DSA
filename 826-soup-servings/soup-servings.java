class Solution {

    double[][] dp;

    public double helper(int a, int b, int[][] adj) {

        if (a <= 0 && b <= 0) {
            return 0.5;
        }

        if (a <= 0) {
            return 1.0;
        }

        if (b <= 0) {
            return 0.0;
        }

        // Already calculated
        if (dp[a][b] != -1.0) {
            return dp[a][b];
        }

        double prob = 0.0;

        for (int i = 0; i < adj.length; i++) {

            int c = adj[i][0];
            int d = adj[i][1];

            prob += helper(a - c, b - d, adj);
        }

        dp[a][b] = prob * 0.25;

        return dp[a][b];
    }

    public double soupServings(int n) {
        if(n>=4500){
            return 1.0;
        }

        int[][] adj = {
            {100, 0},
            {75, 25},
            {50, 50},
            {25, 75}
        };

        dp = new double[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            java.util.Arrays.fill(dp[i], -1.0);
        }

        return helper(n, n, adj);
    }
}