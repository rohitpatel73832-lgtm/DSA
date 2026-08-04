class Solution {

    public int helper(int[] jobDifficulty, int n, int st, int d,int[][] dp) {
        // Last day
        if (d == 1) {
            int mxDays = jobDifficulty[st];
            for (int i = st; i < n; i++) {
                mxDays = Math.max(mxDays, jobDifficulty[i]);
            }
            return dp[st][d]=mxDays;
        }
        if(dp[st][d]!=-1) return dp[st][d];
        int mxDays = Integer.MIN_VALUE;
        int finalAns = Integer.MAX_VALUE;
        for (int i = st; i <= n - d; i++) {
            mxDays = Math.max(mxDays, jobDifficulty[i]);
           int result = mxDays + helper(jobDifficulty, n, i + 1, d - 1,dp);
            finalAns = Math.min(finalAns, result);
        }

        return dp[st][d]=finalAns;
    }

    public int minDifficulty(int[] jobDifficulty, int d) {

        int n = jobDifficulty.length;
        int[][] dp = new int[n][d+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        if (n < d)
            return -1;
        return helper(jobDifficulty, n, 0, d,dp);
    }
}