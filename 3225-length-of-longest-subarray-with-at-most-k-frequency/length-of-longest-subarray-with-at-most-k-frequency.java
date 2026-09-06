class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        Map<Integer, Integer> mp = new HashMap<>();

        int n = nums.length;
        int l = 0;
        int r = 0;
        int ans = 0;

        while (r < n) {

            mp.put(nums[r], mp.getOrDefault(nums[r], 0) + 1);
            while (mp.get(nums[r]) > k) {
                mp.put(nums[l], mp.get(nums[l]) - 1);
                l++;
            }
            ans = Math.max(ans, r - l + 1);

            r++;
        }

        return ans;
    }
}