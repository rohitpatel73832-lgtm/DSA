class Solution {
    public long minCost(int[] nums, int[] cost) {

        int n = nums.length;

        // nums[i], cost[i]
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = cost[i];
        }

        // Sort according to nums
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // Calculate total weight
        long totalCost = 0;

        for (int i = 0; i < n; i++) {
            totalCost += arr[i][1];
        }

        // Find weighted median
        long prefix = 0;
        int target = arr[0][0];

        for (int i = 0; i < n; i++) {

            prefix += arr[i][1];

            if (prefix * 2 >= totalCost) {
                target = arr[i][0];
                break;
            }
        }

        // Calculate answer
        long ans = 0;

        for (int i = 0; i < n; i++) {

            long diff = Math.abs((long) arr[i][0] - target);

            ans += diff * arr[i][1];
        }

        return ans;
    }
}