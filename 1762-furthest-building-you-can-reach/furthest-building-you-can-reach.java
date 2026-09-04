// class Solution {
//     int[][][] dp;
//     public int helper(int st,int[] heights , int bricks, int ladders){
//         if(st==heights.length-1){
//             return 0;
//         }
//         if (dp[st][bricks][ladders] != -1) {
//             return dp[st][bricks][ladders];
//         }
        
//         if(heights[st+1]<=heights[st]){
//             return dp[st][bricks][ladders]= 1+helper(st+1,heights,bricks,ladders);
//         }else{
//             int byBricks=0;
//             int byLadders=0;
//             int diff=heights[st+1]-heights[st];
//             if(bricks>=diff){
//                 byBricks=1+helper(st+1,heights,bricks-diff,ladders);
//             }

//             if(ladders>0){
//                 byLadders=1+helper(st+1,heights,bricks,ladders-1);
//             }

//             return dp[st][bricks][ladders] = Math.max(byBricks,byLadders);
//         }
        
            
        
        
//     }
//     public int furthestBuilding(int[] heights, int bricks, int ladders) {
//         int n=heights.length;
//         dp = new int[n][bricks + 1][ladders + 1];

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j <= bricks; j++) {
//                 Arrays.fill(dp[i][j], -1);
//             }
//         }
//         return helper(0,heights,bricks,ladders);
//     }
// }

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < heights.length - 1; i++) {

            int diff = heights[i + 1] - heights[i];

            if (diff <= 0) {
                continue;
            }

            pq.add(diff);

            if (pq.size() > ladders) {
                bricks -= pq.poll();
            }

            if (bricks < 0) {
                return i;
            }
        }

        return heights.length - 1;
    }
}