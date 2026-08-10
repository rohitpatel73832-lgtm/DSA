// class Solution {
//     public int helper(int left,int[] arr, int right){
//         if(right-left<=2){
//             return 0;
//         }
//         int ans=Integer.MAX_VALUE;
//         for(int i=left+1;i<right; i++){
//             int cost=arr[right]-arr[left]+helper(left,i,arr)+helper(i,right,arr);
//             ans=Math.min(ans,cost);

//         }
//         return ans;
//     }
//     public int minCost(int n, int[] cuts) {
//         int m=cuts.length;
//         int arr= new int[m+2];
//         int nl=arr.length;
//         arr[0]=0;
//         arr[nl-1]=n;
//         for(int i=0; i<m; i++){
//             arr[i+1]=cuts[i];
//         }
//         Arrays.sort(arr);
//         return helper(0,arr,m+1);
//     }
// }

class Solution {

    public int helper(int left, int[] arr, int right, int[][] dp) {

        if (right - left <= 1) {
            return 0;
        }
        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        int ans = Integer.MAX_VALUE;

        for (int i = left + 1; i < right; i++) {

            int cost = arr[right] - arr[left]
                    + helper(left, arr, i, dp)
                    + helper(i, arr, right, dp);

            ans = Math.min(ans, cost);
        }
        return dp[left][right] = ans;
    }

    public int minCost(int n, int[] cuts) {

        int m = cuts.length;

        int[] arr = new int[m + 2];

        arr[0] = 0;
        arr[m + 1] = n;

        for (int i = 0; i < m; i++) {
            arr[i + 1] = cuts[i];
        }

        Arrays.sort(arr);

        int[][] dp = new int[m + 2][m + 2];

        for (int i = 0; i < m + 2; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(0, arr, m + 1, dp);
    }
}