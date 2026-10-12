class Solution {
    public boolean canSplit(int mid, int[] nums, int k){
        int sum = 0;
        int count = 1;

        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > mid) {
                count++;
                sum = 0;
            }

            sum += nums[i];
        }

        return count <= k;
    }
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        int start=0;
        int sum=0;
        for(int i=0; i<n; i++){
            start=Math.max(start,nums[i]);
            sum+=nums[i];
        }

        int l=start;
        int h=sum;
        int answer=0;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(canSplit(mid,nums,k)){
                answer=mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return answer;
    }
}