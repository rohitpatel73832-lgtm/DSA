class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            int t = (int)Math.ceil((double)dist[i]  / speed[i]);

            arr[i][0] = t;
            arr[i][1] = speed[i];
        }

        // Sort by arrival time
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i][0] <= i) {
                return count;
            }

            count++;
        }

        return count;
    }
}