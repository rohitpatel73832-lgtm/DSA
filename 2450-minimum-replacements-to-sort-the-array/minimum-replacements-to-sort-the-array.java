class Solution {
    public long minimumReplacement(int[] nums) {
        int n=nums.length;
        long count=0;
        for(int i=n-2; i>=0; i--){
            if(nums[i]<=nums[i+1]){
                continue;
            }
            int parts=nums[i]/nums[i+1] ;
            if(nums[i]%nums[i+1]!=0){
                parts++;
            }
            count+=parts-1;
            nums[i]=nums[i]/parts;
        }
        return count;
    }
}