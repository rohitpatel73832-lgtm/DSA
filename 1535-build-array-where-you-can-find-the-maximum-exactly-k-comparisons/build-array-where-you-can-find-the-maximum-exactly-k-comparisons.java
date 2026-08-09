// class Solution {
//     public int helper(int st, int searchCost,int maxSoFar,int n, int m, int k,int[][][] dp){
//         if(st==n){
//             if(searchCost==k){
//                 return 1;
//             }
//             else return 0;
//         }
//         if (searchCost > k) {
//             return 0;
//         }
//         if(dp[st][searchCost][maxSoFar+1]!=-1){
//             return dp[st][searchCost][maxSoFar+1];
//         }
        
//         int result=0;
        
//         for(int i=1; i<=m; i++){
//             if(i>maxSoFar){
//                 result+=helper(st+1,searchCost+1,i,n,m,k,dp);
//             }else{
//                 result+=helper(st+1,searchCost,maxSoFar,n,m,k,dp);
//             }
            
//         }
//         return dp[st][searchCost][maxSoFar+1]=result %1000000007;
//     }
//     public int numOfArrays(int n, int m, int k) {
//         int[][][] dp = new int[n][k + 1][m + 2];

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j <= k; j++) {
//                 Arrays.fill(dp[i][j], -1);
//             }
//         }
//         return helper(0,0,-1,n,m,k,dp);
//     }
// }

class Solution {

    public int helper(int st, int searchCost, int maxSoFar,
                      int n, int m, int k, int[][][] dp) {

        if (st == n) {
            if (searchCost == k) {
                return 1;
            } else {
                return 0;
            }
        }

        if (searchCost > k) {
            return 0;
        }

        if (dp[st][searchCost][maxSoFar + 1] != -1) {
            return dp[st][searchCost][maxSoFar + 1];
        }

        int result = 0;

        for (int i = 1; i <= m; i++) {

            if (i > maxSoFar) {

                result += helper(
                    st + 1,
                    searchCost + 1,
                    i,
                    n, m, k, dp
                );

            } else {

                result += helper(
                    st + 1,
                    searchCost,
                    maxSoFar,
                    n, m, k, dp
                );
            }

            result %= 1000000007;
        }

        return dp[st][searchCost][maxSoFar + 1] = result;
    }

    public int numOfArrays(int n, int m, int k) {

        int[][][] dp = new int[n][k + 1][m + 2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return helper(0, 0, -1, n, m, k, dp);
    }
}