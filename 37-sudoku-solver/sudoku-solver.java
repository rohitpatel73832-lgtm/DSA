class Solution {

    public boolean isValid(int row, int col, char num, char[][] board) {

        // Check row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) return false;
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
        }

        // Check 3×3 box
        int r = (row / 3) * 3;
        int c = (col / 3) * 3;

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }

    public boolean solve(int row, int col, char[][] board, char[][] grid) {

        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    grid[i][j] = board[i][j];
                }
            }
            return true;
        }

        if (board[row][col] != '.') {

            if (col != 8)
                return solve(row, col + 1, board, grid);
            else
                return solve(row + 1, 0, board, grid);

        } else {

            for (char ch = '1'; ch <= '9'; ch++) {

                if (isValid(row, col, ch, board)) {

                    board[row][col] = ch;

                    boolean ans;
                    if (col != 8)
                        ans = solve(row, col + 1, board, grid);
                    else
                        ans = solve(row + 1, 0, board, grid);

                    if (ans) return true;

                    board[row][col] = '.';
                }
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {

        char[][] grid = new char[9][9];

        solve(0, 0, board, grid);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = grid[i][j];
            }
        }
    }
}