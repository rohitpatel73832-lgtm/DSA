class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        if(goal<0){
            return 0;
        }
        int sum = 0;
        int count=0;
        int cntZero=0;
        while (r < n) {
           sum += nums[r];
            
            while(l<r &&( nums[l]==0||sum>goal)){
                if(nums[l]==0){
                    cntZero++;
                }else{
                    cntZero=0;
                }
                sum-=nums[l];
                l++;
            }
            if(sum==goal){
                count=count+1+cntZero;
            }
            
             
            r++;
        }
        return count;
    }
}