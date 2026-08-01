// class Solution {
//     public List<Integer> getRow(int numRows) {
//         List<List<Integer>> ans = new ArrayList<>();
//         for (int i = 0; i <= numRows; i++) {

//             List<Integer> adj = new ArrayList<>();

//             for (int j = 0; j <= i; j++) {

//                 if (j == 0 || j == i) {
//                     adj.add(1);
//                 } else {
//                     int a = ans.get(i - 1).get(j - 1);
//                     int b = ans.get(i - 1).get(j);
//                     adj.add(a + b);
//                 }
//             }

//             ans.add(adj);
//         }
//         return ans.get(numRows);
//     }
// }
class Solution {

    public int helper(int row, int col, int[][] dp) {

        if (col == 0 || col == row) {
            return 1;
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        dp[row][col] = helper(row - 1, col - 1, dp)
                     + helper(row - 1, col, dp);

        return dp[row][col];
    }

    public List<Integer> getRow(int rowIndex) {

        List<Integer> ans = new ArrayList<>();

        int[][] dp = new int[rowIndex + 1][rowIndex + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int col = 0; col <= rowIndex; col++) {
            ans.add(helper(rowIndex, col, dp));
        }

        return ans;
    }
}