class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        int n = bloomDay.length;

        if ((long) m * k > n) return -1;

        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;

        // Find minimum and maximum day
        for (int day : bloomDay) {
            l = Math.min(l, day);
            r = Math.max(r, day);
        }

        int ans = -1;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (possible(bloomDay, m, k, mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    public boolean possible(int[] bloomDay, int m, int k, int day) {

        int bouquets = 0;
        int flowers = 0;

        for (int bloom : bloomDay) {

            if (bloom <= day) {
                flowers++;

                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }

        return bouquets >= m;
    }
}