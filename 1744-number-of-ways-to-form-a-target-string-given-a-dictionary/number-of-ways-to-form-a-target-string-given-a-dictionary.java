class Solution {

    public int helper(int i, int j, int[][] freq, String target, int m, int k,long[][] dp) {
        if (i == m) {
            return 1;
        }

        // No more columns
        if (j == k) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return (int) dp[i][j];
        }

        long skip = helper(i, j + 1, freq, target, m, k,dp);
        long take = (long)freq[target.charAt(i) - 'a'][j]* helper(i + 1, j + 1, freq, target, m, k,dp);
        
        long ans = (skip + take) % 1000000007;
        return (int) (dp[i][j] = ans);
    }

    public int numWays(String[] words, String target) {

        int m = target.length();
        int k = words[0].length();

        int[][] freq = new int[26][k];

        // Count characters column-wise
        for (int i = 0; i < k; i++) {
            for (String word : words) {
                char ch = word.charAt(i);
                freq[ch - 'a'][i]++;
            }
        }
        long[][] dp = new long[m][k];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(0, 0, freq, target, m, k,dp);
    }
}