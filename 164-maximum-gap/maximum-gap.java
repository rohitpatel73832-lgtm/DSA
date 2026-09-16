class Solution {
    public int maximumGap(int[] nums) {
        int n=nums.length;
        if(n<2){
            return 0;
        }
        Arrays.sort(nums);
        int l=0;
        int r=1;
        int max=Integer.MIN_VALUE;
        while(r<n){
            int diff=nums[r]-nums[l];
            max=Math.max(max,diff);
            l++;
            r++;
        }
        return max;
    }
}