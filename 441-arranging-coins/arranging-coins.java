class Solution {
    public int arrangeCoins(int n) {
        // double k=(-1 +Math.sqrt(1+8.0*n))/2;
        // double ans=Math.floor(k);
        // return (int)ans;
        int sum=0;
        for(int i=1; i<=n; i++){
            sum+=i*1;
            if(n-sum==0){
                return i;
            }
            if(n-sum<=i){
                return i;
            }
        }
        return -1;
        
    }
}