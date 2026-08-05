class Solution {

    public int helper(int i, int canBuy, int[] prices, int[][] dp) {

        
        if (i == prices.length) {
            return 0;
        }

        
        if (dp[i][canBuy] != -1) {
            return dp[i][canBuy];
        }

        if (canBuy == 1) {

           
            int buy = -prices[i] + helper(i + 1, 0, prices, dp);

            int skip = helper(i + 1, 1, prices, dp);

            dp[i][canBuy] = Math.max(buy, skip);

        } else {

           
            int sell = prices[i] + helper(i + 1, 1, prices, dp);

           
            int hold = helper(i + 1, 0, prices, dp);

            dp[i][canBuy] = Math.max(sell, hold);
        }

        return dp[i][canBuy];
    }

    public int maxProfit(int[] prices) {

        int n = prices.length;

        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(0, 1, prices, dp);
    }
}