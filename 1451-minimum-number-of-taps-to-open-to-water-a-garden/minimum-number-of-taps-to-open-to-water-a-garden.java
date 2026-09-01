class Solution {
    public int minTaps(int n, int[] ranges) {

        int[] maxReach = new int[n + 1];

        // Convert taps into intervals
        for (int i = 0; i <= n; i++) {

            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);

            maxReach[left] = Math.max(maxReach[left], right);
        }

        int taps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < n; i++) {

            farthest = Math.max(farthest, maxReach[i]);

            // Cannot cover this point
            if (i == farthest) {
                return -1;
            }

            // Current tap's coverage has ended,
            // so we need another tap
            if (i == currentEnd) {
                taps++;
                currentEnd = farthest;
            }
        }

        return taps;
    }
}