class Solution {

    public boolean helper(int st, int end, int[] nums, int[] dp) {

        if (st == end)
            return true;

        if (dp[st] != 0) {
            return dp[st] == 1;
        }

        for (int i = 1; i <= nums[st]; i++) {

            int jump = st + i;

            if (jump <= end) {

                if (helper(jump, end, nums, dp)) {
                    dp[st] = 1;
                    return true;
                }
            }
        }

        dp[st] = -1;
        return false;
    }

    public boolean canJump(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];

        return helper(0, n - 1, nums, dp);
    }
}