class Solution {
    public boolean canDivide(int[] nums,int mid, int threshold){
        // int divSum=0;
        // for(int ele: nums){
            
        //     divSum += Math.ceil(ele / mid);
        //     if(ele%mid!=0){
        //         divSum++;
        //     }
        // }

        double divSum=0.0;
        for(int ele: nums){
            divSum+=Math.ceil((double)ele/mid);
        }
        if((int)divSum<=threshold){
            return true;
        }else{
            return false;
        }
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
        int sum=0;
        Arrays.sort(nums);
        int l=1;
        int r=nums[n-1];
        int ans=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(canDivide(nums,mid,threshold)){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}