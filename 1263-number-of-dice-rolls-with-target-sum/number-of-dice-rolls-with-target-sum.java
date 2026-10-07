class Solution {
    public int helper(int n, int k, int target,int[][] dp){
        if(target<0){
            return 0;
        }
        if(n==0){
            if(target==0){
                return 1;
            }else{
                return 0;
            }
        }
        if(dp[n][target]!=-1){
            return dp[n][target];
        }
        int ways=0;
        for(int i=1; i<=k ; i++){
            ways=(ways+helper(n-1,k,target-i,dp))%1000000007;
        }
        return dp[n][target]= ways;
    }
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp= new int[31][1001];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        int ans=helper(n,k,target,dp);
        return ans;
    }
}