class Solution {
    //boolean ans;
    public boolean helper(int[] nums,int i,int sum,int count,Boolean[][] dp){
        if(count == sum/2){
            //ans = true;
            return true;
        }
        if(i>=nums.length){
            return false;
        }

        if(dp[i][count]!=null){
            return dp[i][count];
        }
        

        // helper(nums,i+1,sum,count+nums[i]);
        // helper(nums,i+1,sum,count);

        boolean take=helper(nums,i+1,sum,count+nums[i],dp);
        boolean skip=helper(nums,i+1,sum,count,dp);

        return dp[i][count] = take || skip;

    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int ele:nums){
            sum+=ele;
        }
        if(sum % 2 != 0){
            return false;
        }
        Boolean[][] dp= new Boolean[nums.length][sum];
        return helper(nums,0,sum,0,dp);
        //return ans;
    }
}