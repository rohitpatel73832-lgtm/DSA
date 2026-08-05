class Solution {

    public int helper(int[][] jobs, int st,int[] dp) {

        if (st >= jobs.length)
            return 0;

            if(dp[st]!=-1){
                return dp[st];
            }
        // Find next non-overlapping job
        int next = st + 1;

        while (next < jobs.length && jobs[next][0] < jobs[st][1]) {
            next++;
        }

        int take = jobs[st][2] + helper(jobs, next,dp);

        int skip = helper(jobs, st + 1,dp);

        return dp[st]=Math.max(take, skip);
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int n = startTime.length;

        int[][] jobs = new int[n][3];
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        return helper(jobs, 0,dp);
    }
}