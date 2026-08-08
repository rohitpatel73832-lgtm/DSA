// class Solution {
//     public int helper(int st,int n, int minProfit, int[] group, int[] profit){
//         if(st==profit.length){
//             if (minProfit <= 0) {
//                 return 1;
//             }
//             return 0;
//         }
//         int take=0;
//         int skip=helper(st+1,n,minProfit,group,profit);
//         if(n>=group[st]){
//             take=helper(st+1,n-group[st],minProfit- profit[st],group,profit);
//         }
//         return take+skip;
        
//     }
//     public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
//         return helper(0,n,minProfit,group,profit);
//     }
// }

//memoization
class Solution {

    public int helper(int st,int n, int minProfit, int[] group, int[] profit,int[][][] dp){

        if (st == profit.length) {
            if (minProfit <= 0) {
                return 1;
            }
            return 0;
        }

        if (dp[st][n][minProfit] != -1) {
            return dp[st][n][minProfit];
        }

        int take = 0;

        int skip=helper(st+1,n,minProfit,group,profit,dp);

        if(n>=group[st]){
            take=helper(st+1,n-group[st],Math.max(0, minProfit - profit[st]),group,profit,dp);
        }

        return dp[st][n][minProfit] = (take + skip) % 1000000007;               
    }

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int m = profit.length;

        int[][][] dp = new int[m][n + 1][minProfit + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return helper(0,n,minProfit,group,profit,dp);
    }
}