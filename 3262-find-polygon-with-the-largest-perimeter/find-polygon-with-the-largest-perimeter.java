class Solution {
    public long largestPerimeter(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        long[] sum=new long[n];
        long count=0;
        long ans=-1;
        for(int i=0; i<n; i++){
            count+=nums[i];
            sum[i]=count;
        }
        int i=2;
        while(i<n){
            if(nums[i]<sum[i-1]){
                ans=sum[i];
            }
            i++;
        }
        return ans;

    }
}