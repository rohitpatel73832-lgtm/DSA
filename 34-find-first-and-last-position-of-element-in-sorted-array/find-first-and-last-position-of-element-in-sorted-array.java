// class Solution {
//     public int[] searchRange(int[] nums, int target) {
//         int[] ans= new int[2];
//         Arrays.fill(ans,-1);
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] == target) {
//                 if (ans[0] == -1) {
//                     ans[0] = i;     
//                 }
//                 ans[1] = i;         
//             }
//         }
        
//         return ans;
//     }
// }
class Solution {

    // Find first occurrence
    public int firstOccurrence(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                ans = mid;
                high = mid - 1;   // search on left side
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    // Find last occurrence
    public int lastOccurrence(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                ans = mid;
                low = mid + 1;    // search on right side
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];

        ans[0] = firstOccurrence(nums, target);
        ans[1] = lastOccurrence(nums, target);

        return ans;
    }
}