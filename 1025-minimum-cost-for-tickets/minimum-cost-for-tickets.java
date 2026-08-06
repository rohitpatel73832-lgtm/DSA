class Solution {
    public int helper(int[] days,int i, int[] costs,int[] dp){
        if(i>=days.length){
            return 0;
        }
        if(dp[i]!= -1) return dp[i];
        int ans1=costs[0] + helper(days, i + 1, costs,dp);
        int j = i;
        while (j < days.length && days[j] < days[i] + 7) {
            j++;
        }
        int ans7 = costs[1] + helper(days, j, costs,dp);
        j = i;
        while (j < days.length && days[j] < days[i] + 30) {
            j++;
        }
        int ans30 = costs[2] + helper(days, j, costs,dp);

        return dp[i]= Math.min(ans1, Math.min(ans7, ans30));
    }
    public int mincostTickets(int[] days, int[] costs) {
        int n= days.length;
        int[] dp= new int[n];
        Arrays.fill(dp,-1);
        return helper(days,0,costs,dp);
    }
}