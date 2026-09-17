class Solution {

    public int helper(int amount, int[] coins, int st, int var, int[][] dp) {

        if (var == amount) {
            return 1;
        }

        if (st >= coins.length || var > amount) {
            return 0;
        }

        if (dp[st][var] != -1) {
            return dp[st][var];
        }

        int skip = helper(amount, coins, st + 1, var, dp);

        int take = helper(amount, coins, st, var + coins[st], dp);

        return dp[st][var] = skip + take;
    }

    public int change(int amount, int[] coins) {

        int[][] dp = new int[coins.length][amount + 1];

        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(amount, coins, 0, 0, dp);
    }
}