class Solution {

    public boolean helper(int n, long i) {
        if (i == n) {
            return true;
        }

        if (i > n) {
            return false;
        }

        return helper(n, i * 2);
    }

    public boolean isPowerOfTwo(int n) {

        // if(n<=0) return false;
         // return (n & (n - 1)) == 0;
        return helper(n, 1);
    }
}