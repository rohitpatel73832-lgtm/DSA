class Solution {

    public int helper(int[] nums, int target, int i, int prev,int[][] dp) {

        if (i >= nums.length) {
            return -1000000;
        }

        if (i == nums.length - 1) {
            if (Math.abs(nums[prev] - nums[i]) <= target) {
                return 1;
            } else {
                return -1000000;
            }
        }
        if(dp[i][prev]!=-1){
            return dp[i][prev];
        }

        int take = -1000000;
        int skip = -1000000;

        if (Math.abs(nums[prev] - nums[i]) <= target) {
            take = 1 + helper(nums, target, i + 1, i,dp);
        }

        skip = helper(nums, target, i + 1, prev,dp);

        return dp[i][prev]=Math.max(take, skip);
    }

    public int maximumJumps(int[] nums, int target) {
        int n=nums.length;
        int[][] dp= new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                dp[i][j]=-1;
            }
        }
        int ans = helper(nums, target, 1, 0,dp);
        
        

        if (ans < 0) {
            return -1;
        }

        return ans;
    }
}