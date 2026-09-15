class Solution {
    public boolean isPalindrome(String s, int i, int j,Boolean[][] pal) {

        if (i >= j) {
            return true;
        }

        if (pal[i][j] != null) {
            return pal[i][j];
        }

        if (s.charAt(i) != s.charAt(j)) {
            return pal[i][j] = false;
        }

        return pal[i][j] = isPalindrome(s, i + 1, j - 1,pal);
    }
    public int helper(String s,int k,int i,int[] dp,Boolean[][] pal){
        int n=s.length();
        if(i>=n){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int skip=helper(s,k,i+1,dp,pal);
        int take=0;
        for(int j=i; j<n; j++){
            int len=j-i+1;
            if(len>=k && isPalindrome(s,i,j,pal)){
                take = Math.max(take, 1 + helper(s, k, j + 1,dp,pal));
                
            }
            
        }
        return dp[i]=Math.max(skip,take);
    }
    public int maxPalindromes(String s, int k) {
        int[] dp=new int[s.length()];
        Boolean[][] pal = new Boolean[s.length()][s.length()];
        Arrays.fill(dp,-1);
         return helper(s,k,0,dp,pal);
    }
}