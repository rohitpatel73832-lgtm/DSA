class Solution {

    public int helper(int st, int n, int[] nums, int[] dp) {

        if (st >= n - 1) {
            return 0;
        }

        if (nums[st] == 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[st] != -1) {
            return dp[st];
        }

        int jump = Integer.MAX_VALUE;

        for (int i = 1; i <= nums[st] && st + i < n; i++) {

            int ans = helper(st + i, n, nums, dp);

            if (ans != Integer.MAX_VALUE) {
                jump = Math.min(jump, 1 + ans);
            }
        }

        return dp[st] = jump;
    }

    public int jump(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return helper(0, n, nums, dp);
    }
}