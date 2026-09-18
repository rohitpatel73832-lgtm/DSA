class Solution {
    public boolean helper(int n, long i){
        if(i==n){
            return true;
        }if(i>n){
            return false;
        }

        return helper(n,3*i);
    }
    public boolean isPowerOfThree(int n) {
        return helper(n,1);
    }
}