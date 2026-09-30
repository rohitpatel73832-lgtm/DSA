class Solution {
    public int helper(int i, int j, int[][] grid, int m, int n) {

        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
            return 0;
        }

        int gold = grid[i][j];

        // mark current cell as visited
        grid[i][j] = 0;

        int up = helper(i - 1, j, grid, m, n);
        int down = helper(i + 1, j, grid, m, n);
        int left = helper(i, j - 1, grid, m, n);
        int right = helper(i, j + 1, grid, m, n);

        // restore current cell
        grid[i][j] = gold;

        return gold + Math.max(Math.max(up, down), Math.max(left, right));
    }

    public int getMaximumGold(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int gold = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] != 0) {

                    int ans = helper(i, j, grid, m, n);

                    gold = Math.max(gold, ans);
                }
            }
        }

        return gold;
    }
}