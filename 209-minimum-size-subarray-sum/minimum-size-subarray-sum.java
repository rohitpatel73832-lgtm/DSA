class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int l=0;
        int r=0;
        int count=0;
        int ans=Integer.MAX_VALUE;
        while(r<n){
            count+=nums[r];
            while(count>=target){
                count-=nums[l];
                ans=Math.min(ans,r-l+1);
                l++;
            }
            r++;
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}