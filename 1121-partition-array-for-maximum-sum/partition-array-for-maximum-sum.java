class Solution {
    public int helper(int i, int k, int[] arr,int[] dp){
        if(i>=arr.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int currMax=-1;
        int result=0;
        for(int j=i; j<arr.length && j-i+1<=k; j++){
            currMax=Math.max(currMax, arr[j]);
            result=Math.max(result,((j-i+1)*currMax)+helper(j+1, k,arr,dp));
        }
        return dp[i]= result;
    }  
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[] dp= new int[n];
        Arrays.fill(dp,-1);
        return helper(0,k,arr,dp);
    }
}