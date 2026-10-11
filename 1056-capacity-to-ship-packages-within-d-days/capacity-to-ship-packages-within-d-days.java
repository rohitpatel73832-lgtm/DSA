class Solution {
    public int canShipped(int mid, int[] weights) {
        int n = weights.length;
        int sum = 0;
        int count = 1;

        for (int i = 0; i < n; i++) {
            if (sum + weights[i] > mid) {
                count++;
                sum = 0;
            }

            sum = sum + weights[i];
        }

        return count;
    }

    public int shipWithinDays(int[] weights, int days) {
        int min = Integer.MIN_VALUE;
        int sum = 0;

        for (int ele : weights) {
            min = Math.max(min, ele);
        }

        for (int ele : weights) {
            sum = sum + ele;
        }

        int l = min;
        int h = sum;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (canShipped(mid, weights) <= days) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }

            

        }

        return l;
    }
}