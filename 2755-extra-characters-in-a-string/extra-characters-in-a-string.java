class Solution {
    public int helper(String s,int i,Set<String> st,int n,int[] dp){
        if(i>=n){
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int result=1+helper(s,i+1,st,n,dp);
        for(int j=i; j<n; j++){
            String curr=s.substring(i,j+1);
            if(st.contains(curr)){
                //valid substring
                result=Math.min(result,helper(s,j+1,st,n,dp));
            }
        }
        return dp[i]=result;
    }
    public int minExtraChar(String s, String[] dictionary) {
        int n=s.length();
        Set<String> st= new HashSet<>();
        for(String ele:dictionary){
            st.add(ele);
        }
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(s,0,st,n,dp);
    }
}