class Solution {
    public int[] resultsArray(int[] nums, int k) {
      int n=nums.length;
      int[] ans= new int[n-k+1];
      Arrays.fill(ans,-1);

      //loop method
    //   for(int i=0; i<=n-k; i++){
    //     int curr = nums[i];
    //         boolean valid = true;

    //         for (int j = i + 1; j < i + k; j++) {

    //             if (nums[j] == curr + 1) {
    //                 curr = nums[j];
    //             } else {
    //                 valid = false;
    //                 break;
    //             }
    //         }

    //         if (valid) {
    //             ans[i] = curr;
    //         } else {
    //             ans[i] = -1;
    //         }
    //   }
    //   return ans;

    // by sliding window

    int count=1;
    for(int i=1;i<k; i++){
        if(nums[i]==nums[i-1]+1){
            count++;
        }else{
            count=1;
        }
    }
    if(count==k){
        ans[0]=nums[k-1];
    }

    int l=1; 
    int r=k;
    while(r<n){
        if(nums[r-1]+1==nums[r]){
            count++;
        }else{
            count=1;
        }
        if(count>=k){
            ans[l]=nums[r];
        }
        l++;
        r++;
    }
    return ans;

    }
}