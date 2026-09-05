class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        int score = 0;
        for (int i = 0; i < k; i++) {
            score += cardPoints[i];
        }

        int ans = score;

        int j = n - 1;

        for (int i = k - 1; i >= 0; i--) {
            score -= cardPoints[i];
            score += cardPoints[j];

            ans = Math.max(ans, score);

            j--;
        }

        return ans;
    }
}