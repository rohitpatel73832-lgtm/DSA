class Solution {
    public int helper(int start, int[] nums, int k) {
        if (start >= nums.length) {
            return 0;
        }

        int sum = 0;
        int count = 0;

        for (int i = start; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k) {
                count++;
            }
        }

        return count + helper(start + 1, nums, k);
    }

    public int subarraySum(int[] nums, int k) {
        return helper(0, nums, k);
    }
}