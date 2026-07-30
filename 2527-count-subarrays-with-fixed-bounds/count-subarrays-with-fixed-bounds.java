class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n= nums.length;
        int minkPos=-1;
        int maxkPos=-1;
        int culIdx=-1;
        long ans=0;
        for(int i=0; i<n; i++){
            if(nums[i]>maxK || nums[i]<minK){
                culIdx=i;
            }
            if(nums[i]==minK){
                minkPos=i;
            }
            if(nums[i]==maxK){
                maxkPos=i;                
            }
            long smaller=Math.min(minkPos,maxkPos);
            long temp=smaller-culIdx;
            ans+=(temp<=0)?0:temp;
        }
        return ans;
    }
}