class Solution {
    public int nthUglyNumber(int n) {
        int[] ans= new int[n+1];
        ans[1]=1;
        int u2=1,u3=1,u5=1;
        for(int i=2; i<=n; i++){
            int ugly2=ans[u2]*2;
            int ugly3=ans[u3]*3;
            int ugly5=ans[u5]*5;
            int minUgly=Math.min(Math.min(ugly2,ugly3),ugly5);
            ans[i]=minUgly;

            if(minUgly==ugly2){
                u2++;
            }
            if(minUgly==ugly3){
                u3++;
            }
            if(minUgly==ugly5){
                u5++;
            }
        }
        return ans[n];
    }
}