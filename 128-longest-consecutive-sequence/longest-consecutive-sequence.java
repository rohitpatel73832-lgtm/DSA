class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        Set<Integer> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            st.add(nums[i]);
        }

        int ans = 0;

        for (int num : st) {
            if (!st.contains(num - 1)) {
                int count = 1;
                int curr = num;

                while (st.contains(curr + 1)) {
                    curr++;
                    count++;
                }

                ans = Math.max(ans, count);
            }
        }

        return ans;
    }
}