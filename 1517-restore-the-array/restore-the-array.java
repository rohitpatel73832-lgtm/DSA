class Solution {
    public int helper(int st,int n,String s,int k,int[] dp){
        if(st>=n){
            return 1;
        }
        if(s.charAt(st)=='0'){
            return 0;
        }
        if(dp[st]!=-1){
            return dp[st];
        }

        long num=0;
        int ans=0;
        for(int end=st; end<n; end++){
            num=(num*10)+(s.charAt(end)-'0');
            if(num>k){
                break;
            }
            ans+=helper(end+1,n,s,k,dp);
            ans %= 1000000007;
            
        }
        return dp[st]= (int) ans;
    }
    public int numberOfArrays(String s, int k) {
        int n=s.length();
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return helper(0,n,s,k,dp);
    }
}