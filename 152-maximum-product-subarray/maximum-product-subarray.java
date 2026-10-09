class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int pro = 1;
        int negPro = 1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            pro = pro * nums[i];
            negPro = negPro * nums[n - 1 - i];

            max = Math.max(max, Math.max(pro, negPro));

            if (pro == 0) {
                pro = 1;
            }

            if (negPro == 0) {
                negPro = 1;
            }
        }

        return max;
    }
}