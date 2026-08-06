class Solution {
    public int helper(int st, int time, int n, int[] s, int[][] dp) {
        if (st == n) {
            return 0;
        }
        if (dp[st][time] != -1) {
            return dp[st][time];
        }

        int take = s[st] * time + helper(st + 1, time + 1, n, s, dp);
        int skip = helper(st + 1, time, n, s, dp);

        return dp[st][time] = Math.max(take, skip);
    }

    public int maxSatisfaction(int[] s) {
       Arrays.sort(s);
        int n = s.length;

        int[][] dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(0, 1, n, s, dp);
    }
}