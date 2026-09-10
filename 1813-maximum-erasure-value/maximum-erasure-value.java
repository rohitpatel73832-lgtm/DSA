class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n=nums.length;
        Set<Integer> st= new HashSet<>();
        int sum=0;
        int mxSum=0;
        int l=0;
        int r=0;
        while(r<n){
            if(!st.contains(nums[r])){
                st.add(nums[r]);
                sum+=nums[r];
                
            }else{
                while(nums[l]!=nums[r]){
                    sum-=nums[l];
                    st.remove(nums[l]);
                    l++;
                }
                // remove the old duplicate
                st.remove(nums[l]);
                sum -= nums[l];
                l++;

                // add current element
                st.add(nums[r]);
                sum += nums[r];
            }

            mxSum = Math.max(mxSum, sum);

            r++;
        }
        return mxSum;
    }
}