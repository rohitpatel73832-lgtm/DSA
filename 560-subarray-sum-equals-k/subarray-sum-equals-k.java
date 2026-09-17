// class Solution {
//  Work only for Positive VAlUEl
//     public int subarraySum(int[] nums, int target) {
//         int n = nums.length;
//         int count = 0;
//         int sum = 0;
//         int l = 0;
//         int r = 0;
//         while (r < n) {
//             sum += nums[r];
//             if (sum == target) {
//                 count++;
//             } 
//             if(sum>target) {
//                 while (sum > target) {
//                     sum = sum - nums[l];
//                     l++;
//                 }
//                 if (sum == target) {
//                 count++;
//                 }
            
//             } 
//             r++;
//         }
//         return count;
//     }
// }


class Solution {
    public int subarraySum(int[] nums, int target) {

        int n = nums.length;
        int count = 0;
        int sum = 0;
        int r = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        while (r < n) {

            sum += nums[r];

            if (map.containsKey(sum - target)) {
                count += map.get(sum - target);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);

            r++;
        }

        return count;
    }
}