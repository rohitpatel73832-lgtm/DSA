class Solution {

    public long findSum(int[] nums) {
        long sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        return sum;
    }

    public int findZeros(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            }
        }

        return count;
    }

    public long minSum(int[] nums1, int[] nums2) {

        int nums1Zero = findZeros(nums1);
        int nums2Zero = findZeros(nums2);

        long sum1 = findSum(nums1);
        long sum2 = findSum(nums2);

        // Replace every zero with minimum value 1
        sum1 += nums1Zero;
        sum2 += nums2Zero;

        if (sum1 == sum2) {
            return sum1;
        }

        if (sum1 < sum2) {
            // Need to increase sum1
            if (nums1Zero == 0) {
                return -1;
            }

            return sum2;
        }

        // sum2 < sum1
        if (nums2Zero == 0) {
            return -1;
        }

        return sum1;
    }
}