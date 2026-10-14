class Solution {
    public long findPower(long a, long b){
        if(b==0){
            return 1;
        }
        long val=findPower(a,b/2);
        long result=val*val%1000000007;
        if(b%2!=0){
            result=(result*a)%1000000007;
        }
        return result;
    }
    public int countGoodNumbers(long n) {
        long even=(n+1)/2;
        long odd=n/2;
        long ans=findPower(5,even)*findPower(4,odd);
        ans=ans%1000000007;
        return (int)ans;
    }
}