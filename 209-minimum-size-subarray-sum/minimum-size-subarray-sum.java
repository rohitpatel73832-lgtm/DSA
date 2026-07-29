class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int count=0;
        int ans=Integer.MAX_VALUE;
        int i=0; 
        int j=0;
        while(j<n){
            count+=nums[j];
            while (count >= target) {

                ans = Math.min(ans, j - i + 1);

                count -= nums[i];
                i++;
            }
            j++;
        }
        return  ans == Integer.MAX_VALUE ? 0 : ans;
    }
}