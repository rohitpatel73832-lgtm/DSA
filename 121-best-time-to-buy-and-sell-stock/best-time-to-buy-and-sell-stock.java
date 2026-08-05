// class Solution {

//     public int helper(int st, int n, int canBuy, int done, int[] prices) {

//         if (st == n || done == 1) {
//             return 0;
//         }

//         if (canBuy == 1) {

//             int buy = -prices[st] + helper(st + 1, n, 0, done, prices);

//             int skip = helper(st + 1, n, 1, done, prices);

//             return Math.max(buy, skip);
//         }

//         int sell = prices[st] + helper(st + 1, n, 1, 1, prices);

//         int skip = helper(st + 1, n, 0, done, prices);

//         return Math.max(sell, skip);
//     }

//     public int maxProfit(int[] prices) {

//         return helper(0, prices.length, 1, 0, prices);
//     }
// }
class Solution {

    public int helper(int st, int n, int canBuy, int done, int[] prices, Integer[][][] dp) {

        // Base case
        if (st == n || done == 1) {
            return 0;
        }

        // Memoization
        if (dp[st][canBuy][done] != null) {
            return dp[st][canBuy][done];
        }

        if (canBuy == 1) {

            // Buy
            int buy = -prices[st] + helper(st + 1, n, 0, done, prices, dp);

            // Skip
            int skip = helper(st + 1, n, 1, done, prices, dp);

            return dp[st][canBuy][done] = Math.max(buy, skip);
        }

        // Sell
        int sell = prices[st] + helper(st + 1, n, 1, 1, prices, dp);

        // Skip
        int skip = helper(st + 1, n, 0, done, prices, dp);

        return dp[st][canBuy][done] = Math.max(sell, skip);
    }

    public int maxProfit(int[] prices) {

        int n = prices.length;

        Integer[][][] dp = new Integer[n][2][2];

        return helper(0, n, 1, 0, prices, dp);
    }
}