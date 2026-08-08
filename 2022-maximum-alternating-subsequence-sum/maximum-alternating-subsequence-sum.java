class Solution {

    public long helper(int st, int n, int[] nums, int canAdd, long[][] dp) {

        if (st >= n) {
            return 0;
        }

        if (dp[st][canAdd] != -1) {
            return dp[st][canAdd];
        }

        long take;

        if (canAdd == 1) {
            take = nums[st] + helper(st + 1, n, nums, 0, dp);
        } else {
            take = -nums[st] + helper(st + 1, n, nums, 1, dp);
        }

        long skip = helper(st + 1, n, nums, canAdd, dp);

        return dp[st][canAdd] = Math.max(take, skip);
    }

    public long maxAlternatingSum(int[] nums) {

        int n = nums.length;

        long[][] dp = new long[n][2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(0, n, nums, 1, dp);
    }
}