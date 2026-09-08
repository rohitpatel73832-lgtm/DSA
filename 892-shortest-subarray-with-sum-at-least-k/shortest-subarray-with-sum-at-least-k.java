class Solution {
    public int shortestSubarray(int[] nums, int k) {

        int n = nums.length;

        long[] prefix = new long[n + 1];

        int right = 0;

        while (right < n) {
            prefix[right + 1] = prefix[right] + nums[right];
            right++;
        }

        Deque<Integer> dq = new ArrayDeque<>();

        right = 0;
        int len = Integer.MAX_VALUE;

        while (right <= n) {

            // Find valid subarray
            while (!dq.isEmpty()
                    && prefix[right] - prefix[dq.peekFirst()] >= k) {

                len = Math.min(len,right - dq.removeFirst());
            }

            // Maintain increasing prefix sum
            while (!dq.isEmpty()
                    && prefix[right] <= prefix[dq.peekLast()]) {

                dq.removeLast();
            }

            // Add current index
            dq.add(right);

            right++;
        }

        return len == Integer.MAX_VALUE ? -1 : len;
    }
}