class Solution {
    public int arrangeCoins(int n) {
        double k=(-1 +Math.sqrt(1+8.0*n))/2;
        double ans=Math.floor(k);
        return (int)ans;
        
        
    }
}