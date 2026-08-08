class Solution {

    public int helper(int sr, int k, List<List<Integer>> piles,int[][] dp) {

        if (k == 0) {
            return 0;
        }

        if (sr >= piles.size()) {
            return 0;
        }
        if (dp[sr][k] != -1) {
            return dp[sr][k];
        }

        // Skip 
        int skip = helper(sr + 1, k, piles,dp);

        // Take 
        int sum = 0;
        int take = 0;

        for (int i = 0; i < piles.get(sr).size() && i < k; i++) {

            sum += piles.get(sr).get(i);

            int curr = sum + helper(sr + 1,k - (i + 1),piles,dp);                                       
            take = Math.max(take, curr);
        }

        return dp[sr][k]= Math.max(take, skip);
    }

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(0, k, piles,dp);
    }
}