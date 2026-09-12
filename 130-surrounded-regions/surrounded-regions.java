class Solution {
    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public void dfs(int i, int j, char[][] board){
        int m = board.length;
        int n = board[0].length;

        board[i][j] = '#';  
        //up
        if(i-1>0 && board[i - 1][j] == 'O'){
            dfs(i-1,j,board);
        } 
        // down
        if(i+1<m && board[i + 1][j] == 'O'){
            dfs(i+1,j,board);
        } 
        //right
        if(j+1<n && board[i][j+1] == 'O'){
            dfs(i,j+1,board);
        } 
        //left
        if(j-1>0 && board[i][j-1] == 'O'){
            dfs(i,j-1,board);
        } 
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // First row
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(0, j, board);
            }
        }

        // Last row
        for (int j = 0; j < n; j++) {
            if (board[m - 1][j] == 'O') {
                dfs(m - 1, j, board);
            }
        }

        // First column
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0, board);
            }
        }

        // Last column
        for (int i = 0; i < m; i++) {
            if (board[i][n - 1] == 'O') {
                dfs(i, n - 1, board);
            }
        }

        // Convert remaining O to X and # back to O
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}