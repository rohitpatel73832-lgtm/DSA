class Solution {
    public int helper(int i, int j,int[] nums){
        if(i>j){
            return 0;
        }
        if(i==j){
            return nums[i];
        }
        int takeI=nums[i]+Math.min(helper(i+2,j,nums),helper(i+1,j-1,nums));
        int takeJ=nums[j]+Math.min(helper(i+1,j-1,nums),helper(i,j-2,nums));
        return Math.max(takeI,takeJ);
    }
    public boolean predictTheWinner(int[] nums) {
        int n= nums.length;
        int totalScore=0;
        for(int i=0; i<n; i++){
            totalScore+=nums[i];
        }
        int player1Score=helper(0,n-1,nums);
        int player2Score=totalScore-player1Score;
        return player1Score>=player2Score;
    }
}