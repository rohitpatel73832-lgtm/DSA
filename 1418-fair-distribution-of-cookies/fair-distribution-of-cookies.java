class Solution {

    int result = Integer.MAX_VALUE;
    int n;

    public void helper(int idx, int[] cookies, int[] dup, int k) {

        // all cookies distributed
        if (idx >= n) {

            int unfairness = 0;

            for (int i = 0; i < k; i++) {
                unfairness = Math.max(unfairness, dup[i]);
            }

            result = Math.min(result, unfairness);
            return;
        }

        // Give current cookie to each child
        for (int i = 0; i < k; i++) {

            dup[i] += cookies[idx];

            helper(idx + 1, cookies, dup, k);

            // backtrack
            dup[i] -= cookies[idx];
        }
    }

    public int distributeCookies(int[] cookies, int k) {

        n = cookies.length;

        int[] dup = new int[k];

        helper(0, cookies, dup, k);

        return result;
    }
}