// class Solution {

//     public int helper(int sr, int sc, int[][] matrix, int ec, int er, int[][] dp) {

//         // Base case
//         if (sr == er) {
//             return matrix[sr][sc];
//         }

//         // Memoization
//         if (dp[sr][sc] != -1) {
//             return dp[sr][sc];
//         }

//         int takeL = Integer.MAX_VALUE;
//         int take = Integer.MAX_VALUE;
//         int takeR = Integer.MAX_VALUE;

//         // Down Left
//         if (sc > 0) {
//             takeL = matrix[sr][sc] + helper(sr + 1, sc - 1, matrix, ec, er, dp);
//         }

//         // Down
//         take = matrix[sr][sc] + helper(sr + 1, sc, matrix, ec, er, dp);

//         // Down Right
//         if (sc < ec) {
//             takeR = matrix[sr][sc] + helper(sr + 1, sc + 1, matrix, ec, er, dp);
//         }

//         return dp[sr][sc] = Math.min(takeL, Math.min(take, takeR));
//     }

//     public int minFallingPathSum(int[][] matrix) {

//         int n = matrix.length;
//         int m = matrix[0].length;

//         int[][] dp = new int[n][m];

//         for (int i = 0; i < n; i++) {
//             Arrays.fill(dp[i], -1);
//         }

//         int ans = Integer.MAX_VALUE;

//         // Try every starting column
//         for (int j = 0; j < m; j++) {
//             ans = Math.min(ans, helper(0, j, matrix, m - 1, n - 1, dp));
//         }

//         return ans;
//     }
// }
class Solution {

    public int helper(int sr, int sc, int[][] matrix, int ec, int er, Integer[][] dp) {

        // Base case
        if (sr == er) {
            return matrix[sr][sc];
        }

        // Memoization
        if (dp[sr][sc] != null) {
            return dp[sr][sc];
        }

        int takeL = Integer.MAX_VALUE;
        int take = Integer.MAX_VALUE;
        int takeR = Integer.MAX_VALUE;

        // Down Left
        if (sc > 0) {
            takeL = matrix[sr][sc] + helper(sr + 1, sc - 1, matrix, ec, er, dp);
        }

        // Down
        take = matrix[sr][sc] + helper(sr + 1, sc, matrix, ec, er, dp);

        // Down Right
        if (sc < ec) {
            takeR = matrix[sr][sc] + helper(sr + 1, sc + 1, matrix, ec, er, dp);
        }

        return dp[sr][sc] = Math.min(takeL, Math.min(take, takeR));
    }

    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        Integer[][] dp = new Integer[n][m];

        int ans = Integer.MAX_VALUE;

        // Try every starting column
        for (int j = 0; j < m; j++) {
            ans = Math.min(ans, helper(0, j, matrix, m - 1, n - 1, dp));
        }

        return ans;
    }
}