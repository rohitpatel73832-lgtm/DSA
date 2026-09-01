class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        int j = n - 1;

        int[] first = new int[k];
        int[] second = new int[n - k];

        // Last k elements
        for (int i = 0; i < k; i++) {
            first[i] = nums[j];
            j--;
        }

        // Reverse first
        for (int i = 0, j1 = first.length - 1; i < j1; i++, j1--) {
            int temp = first[i];
            first[i] = first[j1];
            first[j1] = temp;
        }

        // First n-k elements
        for (int i = 0; i < n - k; i++) {
            second[i] = nums[i];
        }

        // Combine
        int[] combine = new int[n];
        int i = 0;

        for (i = 0; i < first.length; i++) {
            combine[i] = first[i];
        }

        for (int p = 0; p < second.length; p++) {
            combine[i++] = second[p];
        }

        // Copy back to nums
        for (int p = 0; p < n; p++) {
            nums[p] = combine[p];
        }
    }
}