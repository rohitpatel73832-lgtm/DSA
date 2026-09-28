class Solution {

    public int helper(int i, int j, int[][] grid, int count) {

        if (i < 0 || i >= grid.length ||
            j < 0 || j >= grid[0].length ||
            grid[i][j] == -1) {
            return 0;
        }

        if (grid[i][j] == 2) {
            if (count == 0) {
                return 1;
            }
            return 0;
        }

        //int newCount = count;

        if (grid[i][j] == 0) {
            count--;
        }

        grid[i][j] = -1;

        int ans = 0;

        ans += helper(i - 1, j, grid, count);
        ans += helper(i + 1, j, grid, count);
        ans += helper(i, j - 1, grid, count);
        ans += helper(i, j + 1, grid, count);

        grid[i][j] = 0;

        return ans;
    }

    public int uniquePathsIII(int[][] grid) {

        int count = 0;
        int si = 0;
        int sj = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 0) {
                    count++;
                }

                if (grid[i][j] == 1) {
                    si = i;
                    sj = j;
                }
            }
        }

        return helper(si, sj, grid, count);
    }
}