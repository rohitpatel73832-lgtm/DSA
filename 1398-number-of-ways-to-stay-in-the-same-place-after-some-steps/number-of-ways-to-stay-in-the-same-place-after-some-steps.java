class Solution {
    public int helper(int steps, int arrLen, int i,int[][] dp){
        if(steps==0 && i==0){
            return 1;
        }

        if(steps==0 || i<0 || i>=arrLen){
            return 0;
        }
        if(dp[steps][i]!=-1){
            return dp[steps][i];
        }
        int back=0;
        int next=0;
        if(i>0){
            back=helper(steps-1,arrLen,i-1,dp);
        }
        int stay=helper(steps-1,arrLen,i,dp);
        if(i<arrLen-1){
            next=helper(steps-1,arrLen,i+1,dp);
        }
        return dp[steps][i] = (int)(((long)back + stay + next) % 1000000007);
    }
    public int numWays(int steps, int arrLen) {
        int maxLen = Math.min(arrLen, steps / 2 + 1);
        int[][] dp= new int[steps+1][maxLen];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return helper(steps,maxLen,0,dp);
    }
}