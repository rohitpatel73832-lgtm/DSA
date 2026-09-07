class Solution {
    public int minSwaps(int[] nums) {

        int n = nums.length;

        int totalOnes = 0;

        for(int ele : nums){
            if(ele == 1){
                totalOnes++;
            }
        }

        if(totalOnes == 0){
            return 0;
        }

        int currOnes = 0;

        for(int i = 0; i < totalOnes; i++){
            if(nums[i] == 1){
                currOnes++;
            }
        }

        int minSwap = totalOnes - currOnes;

        int l = 0;
        int r = totalOnes;

        while (l < n) {

            if (nums[r % n] == 1) {
                currOnes++;
            }

            if (nums[l] == 1) {
                currOnes--;
            }

            minSwap = Math.min(minSwap, totalOnes - currOnes);

            l++;
            r++;
        }
        return minSwap;
    }
}