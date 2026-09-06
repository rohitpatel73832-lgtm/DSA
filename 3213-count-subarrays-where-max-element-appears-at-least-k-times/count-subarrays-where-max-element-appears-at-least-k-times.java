class Solution {
    public long countSubarrays(int[] nums, int k) {

        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }

        int l = 0;
        int r = 0;
        int count = 0;
        long ans = 0;

        while (r < n) {
            if (nums[r] == max) {
                count++;
            }
            while (count >= k) {
                ans += n - r;

                if (nums[l] == max) {
                    count--;
                }

                l++;
            }

            r++;
        }

        return ans;
    }
}