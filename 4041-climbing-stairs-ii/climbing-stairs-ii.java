class Solution {
    public int helper(int i, int n, int[] costs,int[] dp){
        if(i==n){
            return 0;
        }
        if(dp[i]!=Integer.MAX_VALUE){
            return dp[i];
        }

        int jump=Integer.MAX_VALUE;
        int jumpOne=Integer.MAX_VALUE;
        int jumpTwo=Integer.MAX_VALUE;

        if(i+1<=n){
            jump=costs[i]+(i+1-i)*(i+1-i) +helper(i+1,n,costs,dp);
        }
        if(i+2<=n){
            jumpOne=costs[i+1]+(i+2-i)*(i+2-i) +helper(i+2,n,costs,dp);
        }
        if(i+3<=n){
            jumpTwo=costs[i+2]+(i+3-i)*(i+3-i) +helper(i+3,n,costs,dp);
        }
         
        return dp[i]= Math.min(jump,Math.min(jumpOne,jumpTwo));
    }
    public int climbStairs(int n, int[] costs) {
        int[] dp= new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        return helper(0,n,costs,dp);
    }
}