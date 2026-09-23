class Solution {
    public int[] findErrorNums(int[] nums) {
        
        int n = nums.length;
        
        HashSet<Integer> st = new HashSet<>();
        int duplicate = -1;

        for(int i = 0; i < n; i++) {
            
            if(st.contains(nums[i])) {
                duplicate = nums[i];
            }
            
            st.add(nums[i]);
        }

        int missing = -1;

        for(int i = 1; i <= n; i++) {
            if(!st.contains(i)) {
                missing = i;
                break;
            }
        }

        return new int[]{duplicate, missing};
    }
}