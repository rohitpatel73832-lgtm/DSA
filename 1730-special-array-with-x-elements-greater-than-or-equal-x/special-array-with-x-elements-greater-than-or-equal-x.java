class Solution {
    public int find(int idx, int[] nums) {

        int l = 0;
        int r = nums.length - 1;

        int ans = nums.length;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (nums[mid] >= idx) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return nums.length - ans;
    }

    public int specialArray(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 1; i <= n; i++) {

            if (i == find(i, nums)) {
                return i;
            }
        }

        return -1;
    }
}