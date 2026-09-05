class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n=nums.length;
        int r=0;
        int l=0;
        int ans=0;
        int count=0;
        while(r<n){
            int a=nums[r];
            if(a!=0){
                ans=ans+1;
                count=Math.max(count,ans);
                r++;
            }else{
                ans=0;
                l=r+1;
                r=r+1;
            }
        }
        return count;
    }
}