class Solution {
    double[][] dp;

    public double helper(int poured, int i, int j) {
        if (i < 0 || j < 0 || i < j) {
            return 0.0;
        }

        if (i == 0 && j == 0) {
            return poured;
        }

        if (dp[i][j] != -1.0) {
            return dp[i][j];
        }

        double up_left = (helper(poured, i - 1, j - 1) - 1) / 2.0;
        double up_right = (helper(poured, i - 1, j) - 1) / 2.0;

        if (up_left < 0) {
            up_left = 0.0;
        }

        if (up_right < 0) {
            up_right = 0.0;
        }

        return dp[i][j] = up_left + up_right;
    }

    public double champagneTower(int poured, int row, int col) {
        dp = new double[row + 1][row + 1];

        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= row; j++) {
                dp[i][j] = -1.0;
            }
        }

        return Math.min(1.0, helper(poured, row, col));
    }
}