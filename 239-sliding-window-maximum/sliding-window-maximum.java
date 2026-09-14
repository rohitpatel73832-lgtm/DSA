// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {

//         int n = nums.length;
//         List<Integer> adj = new ArrayList<>();

//         int max = Integer.MIN_VALUE;

//         for (int i = 0; i < k; i++) {
//             max = Math.max(max, nums[i]);
//         }

//         adj.add(max);

//         int l = 1;
//         int r = k;
//         int maxIdx=0;

//         while (r < n) {

//             max = Integer.MIN_VALUE;

//             int p = l;
//             if(maxIdx>=l && maxIdx<=r){
//                 if(nums[r]<nums[maxIdx]){
//                     ans.add(nums[maxIdx]);
//                 }
//             }else{
//                 while (l <= r) {
//                 max = Math.max(max, nums[l]);
//                 l++;
//             }

//             adj.add(max);
//             maxIdx=l;
//             l = p + 1;
//             r++;
//             }

            
//         }

//         int[] ans = new int[adj.size()];

//         for (int i = 0; i < adj.size(); i++) {
//             ans[i] = adj.get(i);
//         }

//         return ans;
//     }
// }

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        List<Integer> adj = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        int maxIdx = 0;

        // First window
        for (int i = 0; i < k; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }

        adj.add(max);

        int l = 1;
        int r = k;

        while (r < n) {

            // If old maximum is still inside the window
            if (maxIdx >= l && maxIdx <= r) {

                // New element is bigger
                if (nums[r] > nums[maxIdx]) {
                    max = nums[r];
                    maxIdx = r;
                } else {
                    max = nums[maxIdx];
                }

            } else {

                // Old maximum is outside the window
                max = Integer.MIN_VALUE;

                for (int i = l; i <= r; i++) {
                    if (nums[i] > max) {
                        max = nums[i];
                        maxIdx = i;
                    }
                }
            }

            adj.add(max);

            l++;
            r++;
        }

        int[] ans = new int[adj.size()];

        for (int i = 0; i < adj.size(); i++) {
            ans[i] = adj.get(i);
        }

        return ans;
    }
}