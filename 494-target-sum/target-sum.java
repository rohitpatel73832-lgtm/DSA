class Solution {
    static int sum;
    public int helper(int i, int[] nums, int target, String s,int[][] dp){
        if(i>=nums.length){
            if(target==0){
                return 1;
            }else{
                return 0;
            }
        }
        if (target < -sum || target > sum) {
            return 0;
        }
        if(dp[i][target+sum]!=-1){
            return dp[i][target+sum];
        } 
        int add=helper(i+1,nums,target-nums[i],s+"+"+nums[i],dp);
        int sub=helper(i+1,nums,target+nums[i],s+"-"+nums[i],dp);
        return dp[i][target+sum]=add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        sum=0;
        for(int ele:nums){
            sum+=ele;
        }
        int[][] dp=new int[n][2*sum+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
       return helper(0,nums,target,"",dp);
    }
}