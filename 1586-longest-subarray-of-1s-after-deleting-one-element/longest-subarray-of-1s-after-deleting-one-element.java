class Solution {

    Integer[][] dp;

    public int helper(int i, int del, int[] nums) {

        if (i == nums.length)
            return 0;

        if (dp[i][del] != null)
            return dp[i][del];

        int ans = 0;

        if (nums[i] == 1) {
            ans = 1 + helper(i + 1, del, nums);
        } else {

            if (del == 0) {
                ans = helper(i + 1, 1, nums);
            } else {
                ans = 0;
            }
        }

        return dp[i][del] = ans;
    }

    public int longestSubarray(int[] nums) {

        int n = nums.length;

        dp = new Integer[n][2];

        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, helper(i, 0, nums));
        }

        if (ans == n)
            return n - 1;

        return ans;
    }
}