class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int l=0; 
        int r=0;
        int count=0;
        int mxLen=0;
        while(r<n){
            if (nums[r] == 0) {
                count++;
            }

            r++;
            while (count > k) {

                if (nums[l] == 0) {
                    count--;
                }

                l++;
            }
            mxLen = Math.max(mxLen, r - l);
        }

        return mxLen;
    }
}