class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        int n = nums.length;
        long maxSum = 0;
        long sum = 0;

        Set<Integer> st = new HashSet<>();

        int l = 0;
        int r = 0;

        while (r < n) {

            // Remove duplicates
            while (st.contains(nums[r])) {
                st.remove(nums[l]);
                sum -= nums[l];
                l++;
            }

            // Add current element
            st.add(nums[r]);
            sum += nums[r];

            // Window size is k
            if (r - l + 1 == k) {
                maxSum = Math.max(maxSum, sum);

                // Remove left element
                st.remove(nums[l]);
                sum -= nums[l];
                l++;
            }

            r++;
        }

        return maxSum;
    }
}