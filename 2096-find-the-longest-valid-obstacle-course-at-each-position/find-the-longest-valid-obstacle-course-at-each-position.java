// class Solution {
//     public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
//         int n=obstacles.length;
//         int[] dp= new int[n];
//         Arrays.fill(dp,1);
//         for(int i=0; i<n; i++){
//             for(int j=0; j<i; j++){
//                 if(obstacles[j]<=obstacles[i]){
//                     dp[i]=Math.max(dp[i],dp[j]+1);
//                 }
//             }
//         }
//         return dp;
//     }
// }

//binary search
class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {

        int n = obstacles.length;

        int[] ans = new int[n];
        int[] tails = new int[n];

        int size = 0;

        for (int i = 0; i < n; i++) {

            int left = 0;
            int right = size;

            // Find first element > obstacles[i]
            while (left < right) {

                int mid = left + (right - left) / 2;

                if (tails[mid] <= obstacles[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            tails[left] = obstacles[i];

            ans[i] = left + 1;

            if (left == size) {
                size++;
            }
        }

        return ans;
    }
}