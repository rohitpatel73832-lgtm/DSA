class Solution {
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    public int helper(int operation, int[] nums, boolean[] used,int[] dp) {

        // All operations completed
        if (operation > nums.length / 2) {
            return 0;
        }
        int state = 0;

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                state += (int)Math.pow(2, i);
            }
        }

        if (dp[state] != -1) {
            return dp[state];
        }

        int ans = 0;

        // Choose first number
        for (int i = 0; i < nums.length; i++) {

            if (used[i]) {
                continue;
            }

            // Choose second number
            for (int j = i + 1; j < nums.length; j++) {

                if (used[j]) {
                    continue;
                }

                // TAKE i and j
                used[i] = true;
                used[j] = true;

                int take =operation * gcd(nums[i], nums[j])+ helper(operation + 1, nums, used,dp);
                    
                ans = Math.max(ans, take);

                // Backtrack
                used[i] = false;
                used[j] = false;
            }
        }

        return dp[state]=ans;
    }

    public int maxScore(int[] nums) {
        int n=nums.length;
        boolean[] used = new boolean[nums.length];
        int[] dp = new int[(int)Math.pow(2, n)];
        Arrays.fill(dp, -1);

        return helper(1, nums, used,dp);
    }   
}