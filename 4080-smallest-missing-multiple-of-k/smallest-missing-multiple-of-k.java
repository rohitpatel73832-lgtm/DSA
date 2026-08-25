class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n=nums.length;
        HashSet<Integer> st= new HashSet<>();
        
        for(int i=0; i<n; i++){
            st.add(nums[i]);
        }
        for(int i=1; i<=n+1; i++){
            if(!st.contains(k*i)){
                return k*i;
            }
        }
        return 0;
    }
}