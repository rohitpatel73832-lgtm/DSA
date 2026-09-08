class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n=nums.length;
        long count=0;
        
        int l=0;
        int r=0;
        long sum=0;
        long score=0;
        long len=0;
        

        while(r<n){
            sum=sum+nums[r];
            len=r-l+1;
            score=sum*len;
            
            
            while(score>=k){
                sum=sum-nums[l];
                l++;
                len=r-l+1;
                score=sum*len;
                
            }
            
            count+=r-l+1;
            r++;

        }
        return count;
    }
}