class Solution {
    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public void dfs(int i, int j, int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        grid[i][j] = 0;
        //up
        if(i-1>0 && grid[i - 1][j] == 1){
            dfs(i-1,j,grid);
        } 
        // down
        if(i+1<m && grid[i + 1][j] == 1){
            dfs(i+1,j,grid);
        } 
        //right
        if(j+1<n && grid[i][j+1] == 1){
            dfs(i,j+1,grid);
        } 
        //left
        if(j-1>0 && grid[i][j-1] == 1){
            dfs(i,j-1,grid);
        } 
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // First row
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1) {
                dfs(0, j, grid);
            }
        }

        // Last row
        for (int j = 0; j < n; j++) {
            if (grid[m - 1][j] == 1) {
                dfs(m - 1, j, grid);
            }
        }

        // First column
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                dfs(i, 0, grid);
            }
        }

        // Last column
        for (int i = 0; i < m; i++) {
            if (grid[i][n - 1] == 1) {
                dfs(i, n - 1, grid);
            }
        }

        // Count remaining 1s
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}