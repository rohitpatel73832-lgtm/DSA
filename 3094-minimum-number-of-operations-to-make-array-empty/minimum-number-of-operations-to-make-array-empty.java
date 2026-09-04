class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer,Integer> mp= new HashMap<>();
        int count=0;
        int n=nums.length;
        for(int i=0; i<n; i++){
           mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }
        for (int freq : mp.values()) {
           if(freq==1){
            return -1;
           }
           count+=freq/3;
           if(freq%3!=0){
            count++;
           }
        }
        return count;
    }
}