class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n=nums.length;
        Set<Integer> st= new HashSet<>();
        int unique=0;
        for(int i=0; i<n; i++){
            if(st.size()==0){
                st.add(nums[i]);
                unique++;
            }
            if(!st.contains(nums[i])){
                st.add(nums[i]);
                unique++;
            }
        }

        int l=0; 
    int r=0;
    int count=0;
    HashMap<Integer,Integer> mp= new HashMap<>();
    while(r<n){
       mp.put(nums[r], mp.getOrDefault(nums[r], 0) + 1);
        
        while (mp.size() == unique) {

                count += n - r;

                mp.put(nums[l], mp.get(nums[l]) - 1);

                if (mp.get(nums[l]) == 0) {
                    mp.remove(nums[l]);
                }

                l++;
            }
        r++;
        
    }
    return count;
    }

}