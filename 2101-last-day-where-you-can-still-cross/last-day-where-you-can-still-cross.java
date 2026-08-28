class Solution {

    public boolean dfs(int[][] grid, boolean[][] visited,int r, int c, int row, int col) {
        if (r == row - 1) {
            return true;
        }

        visited[r][c] = true;

        // UP
        if (r - 1 >= 0 &&
            grid[r - 1][c] == 0 &&
            !visited[r - 1][c]) {

            if (dfs(grid, visited, r - 1, c, row, col)) {
                return true;
            }
        }

        // DOWN
        if (r + 1 < row &&
            grid[r + 1][c] == 0 &&
            !visited[r + 1][c]) {

            if (dfs(grid, visited, r + 1, c, row, col)) {
                return true;
            }
        }

        // LEFT
        if (c - 1 >= 0 &&
            grid[r][c - 1] == 0 &&
            !visited[r][c - 1]) {

            if (dfs(grid, visited, r, c - 1, row, col)) {
                return true;
            }
        }

        // RIGHT
        if (c + 1 < col &&
            grid[r][c + 1] == 0 &&
            !visited[r][c + 1]) {

            if (dfs(grid, visited, r, c + 1, row, col)) {
                return true;
            }
        }

        return false;
    }

    public boolean canCross(int[][] grid, int row, int col) {

        boolean[][] visited = new boolean[row][col];

        // Start from every land cell in top row
        for (int j = 0; j < col; j++) {

            if (grid[0][j] == 0) {

                if (dfs(grid, visited, 0, j, row, col)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isValid(int row, int col, int[][] cells, int day) {

        int[][] grid = new int[row][col];

        // Flood first 'day' cells
        for (int i = 0; i < day; i++) {

            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;

            grid[r][c] = 1;
        }

        return canCross(grid, row, col);
    }

  // using normal dfs

//     public int latestDayToCross(int row, int col, int[][] cells) {

//         int[][] grid = new int[row][col];

//         int answer = 0;

//         for (int day = 0; day < cells.length; day++) {
//             int r = cells[day][0] - 1;
//             int c = cells[day][1] - 1;


//             grid[r][c] = 1;

//             if (canCross(grid, row, col)) {
//                 answer = day + 1;
//             } else {
//                 break;
//             }
//         }

//         return answer;
//     }
// }

// by binary search
 public int latestDayToCross(int row, int col, int[][] cells) {

        int l = 0;
        int r = cells.length;

        int result = 0;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (isValid(row, col, cells, mid)) {

                result = mid;

                // Try more days
                l = mid + 1;

            } else {

                // Too many cells flooded
                r = mid - 1;
            }
        }

        return result;
    }
}