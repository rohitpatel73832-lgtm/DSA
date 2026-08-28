class Solution {
    public boolean isValid(int[] nums, int mid, int n) {

    long[] arr = new long[n];

    for (int i = 0; i < n; i++) {
        arr[i] = nums[i];
    }

    for (int i = n - 1; i > 0; i--) {

        if (arr[i] > mid) {
            long buffer = arr[i] - mid;

            arr[i] -= buffer;
            arr[i - 1] += buffer;
        }
    }

    return arr[0] <= mid;
}

    public int maximum(int[] nums) {

        int max = Integer.MIN_VALUE;

        for (int x : nums) {
            if (x > max) {
                max = x;
            }
        }

        return max;
    }

    public int minimizeArrayValue(int[] nums) {

        int n = nums.length;

        int l = 0;
        int r = maximum(nums);

        int result = 0;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (isValid(nums, mid, n)) {

                result = mid;
                r = mid - 1;

            } else {

                l = mid + 1;
            }
        }

        return result;
    }
}