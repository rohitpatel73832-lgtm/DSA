class Solution {
    public boolean helper(int n, long i){
        if(i==n){
            return true;
        }if(i>n){
            return false;
        }

        return helper(n,4*i);
    }
    public boolean isPowerOfFour(int n) {
        return helper(n,1);
    }
}