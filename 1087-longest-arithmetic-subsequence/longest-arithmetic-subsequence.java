// class Solution {

//     public int helper(int st, int prev, int diff, int n, int[] nums,int[][][] dp) {

//         if (st >= n) {
//             return 0;
//         }

//         int take = 0;
//         int skip = helper(st + 1, prev, diff, n, nums,dp);

//         if (prev == -1) {
//             // Choose first element
//             take = 1 + helper(st + 1, st, diff, n, nums,dp);

//         } else if (diff == Integer.MIN_VALUE) {

//             // Choose second element and establish difference
//             take = 1 + helper(st + 1,st,nums[st] - nums[prev],n,nums,dp);
//         } else if (nums[st] - nums[prev] == diff) {

//             // Continue arithmetic sequence
//             take = 1 + helper(st + 1,st,diff,n,nums,dp);
//         }

//         return Math.max(take, skip);
//     }

//     public int longestArithSeqLength(int[] nums) {

//         int n = nums.length;
//         int[][][] dp = new int[n][n + 1][1002];
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j <= n; j++) {
//                 Arrays.fill(dp[i][j], -1);
//             }
//         }
//         return helper(0,-1,Integer.MIN_VALUE, n, nums,dp );
               
//     }
// }

class Solution {

    public int longestArithSeqLength(int[] nums) {

        int n = nums.length;

        // Difference can range from -500 to 500
        int[][] dp = new int[n][1001];

        int ans = 2;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {

                int diff = nums[i] - nums[j];

                // Convert -500...500 to 0...1000
                int d = diff + 500;

                // If no previous sequence exists,
                // start with nums[j], nums[i]
                if (dp[j][d] == 0) {
                    dp[i][d] = Math.max(dp[i][d], 2);
                } else {
                    dp[i][d] = Math.max(dp[i][d],dp[j][d] + 1);

                }

                ans = Math.max(ans, dp[i][d]);
            }
        }

        return ans;
    }
}