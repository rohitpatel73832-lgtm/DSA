class Solution {
    int[][][] dp;
    public int helper(int idx,String[] strs, int m, int n){
        if(idx>=strs.length){
            return 0;
        }
        if(dp[idx][m][n] != -1){
            return dp[idx][m][n];
        }
        int cZero=0;
        int cOne=0;
        String s=strs[idx];
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='0'){
                cZero++;
            }else{
                cOne++;
            }
        }
        int take=0;
        if(cZero <= m && cOne <= n){
            take=1+helper(idx+1,strs,m-cZero,n-cOne);
        }

        int skip = helper(idx + 1, strs, m, n);
         return dp[idx][m][n]= Math.max(take, skip);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        dp = new int[strs.length][m + 1][n + 1];

        for(int i = 0; i < strs.length; i++){
            for(int j = 0; j <= m; j++){
                for(int k = 0; k <= n; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return helper(0,strs,m,n);
       
    }
}