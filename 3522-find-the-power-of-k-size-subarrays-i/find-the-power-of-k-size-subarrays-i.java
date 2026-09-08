class Solution {
    public int[] resultsArray(int[] nums, int k) {
      int n=nums.length;
      int[] ans= new int[n-k+1];
      for(int i=0; i<=n-k; i++){
        int curr = nums[i];
            boolean valid = true;

            for (int j = i + 1; j < i + k; j++) {

                if (nums[j] == curr + 1) {
                    curr = nums[j];
                } else {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                ans[i] = curr;
            } else {
                ans[i] = -1;
            }
      }
      return ans;
    }
}