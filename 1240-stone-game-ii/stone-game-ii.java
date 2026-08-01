import java.util.Arrays;

class Solution {

    int[][][] dp;

    public int helperForAlice(int[] piles, int person, int i, int M, int n) {

        if (i >= n) {
            return 0;
        }

        if (dp[i][M][person] != -1) {
            return dp[i][M][person];
        }

        int result = (person == 1) ? -1 : Integer.MAX_VALUE;
        int stones = 0;

        for (int x = 1; x <= Math.min(2 * M, n - i); x++) {

            stones += piles[i + x - 1];

            if (person == 1) { // Alice
                result = Math.max(result,
                        stones + helperForAlice(piles, 0, i + x, Math.max(M, x), n));
            } else { // Bob
                result = Math.min(result,
                        helperForAlice(piles, 1, i + x, Math.max(M, x), n));
            }
        }

        return dp[i][M][person] = result;
    }

    public int stoneGameII(int[] piles) {

        int n = piles.length;
        dp = new int[n][n + 1][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return helperForAlice(piles, 1, 0, 1, n);
    }
}