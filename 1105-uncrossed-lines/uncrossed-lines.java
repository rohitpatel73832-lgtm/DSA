class Solution {
    public int helper(int i, int j, int m, int n,int[] nums1, int[] nums2,int[][] dp){
        if(i>=m || j>=n){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        if(nums1[i]==nums2[j]){
            ans=1+helper(i+1,j+1,m,n,nums1,nums2,dp);
        }else{
            ans=Math.max(helper(i,j+1,m,n,nums1,nums2,dp),helper(i+1,j,m,n,nums1,nums2,dp));
        }
        return dp[i][j]=ans;

    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int[][] dp= new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j]=-1;
            }
        }
        return helper(0,0,m,n,nums1,nums2,dp);
    }
}