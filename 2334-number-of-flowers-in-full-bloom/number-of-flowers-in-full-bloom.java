class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {

        int m = flowers.length;

        int[] start = new int[m];
        int[] end = new int[m];

        for (int i = 0; i < m; i++) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int[] ans = new int[people.length];

        for (int i = 0; i < people.length; i++) {

            int p = people[i];

            // Number of flowers whose start <= p
            int started = upperBound(start, p);

            // Number of flowers whose end < p
            int finished = lowerBound(end, p);

            ans[i] = started - finished;
        }

        return ans;
    }

    // First index where arr[index] > target
    private int upperBound(int[] arr, int target) {
        int l = 0;
        int r = arr.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

    // First index where arr[index] >= target
    private int lowerBound(int[] arr, int target) {
        int l = 0;
        int r = arr.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}