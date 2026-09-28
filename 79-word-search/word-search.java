class Solution {
    public boolean helper(int idx, int ri, int rj, char[][] board, String word){
        if (idx == word.length()) {
            return true;
        }
        if( ri>=board.length || rj>=board[0].length || ri<0 || rj<0 || board[ri][rj] != word.charAt(idx)){
            return false;
        }
        char temp = board[ri][rj];
        board[ri][rj] = '#';
        // up
        if (helper(idx + 1, ri - 1, rj, board, word)) {
            return true;
        }

        // down
        if (helper(idx + 1, ri + 1, rj, board, word)) {
            return true;
        }

        // left
        if (helper(idx + 1, ri, rj - 1, board, word)) {
            return true;
        }

        // right
        if (helper(idx + 1, ri, rj + 1, board, word)) {
            return true;
        }

        board[ri][rj] = temp;

        return false;
    }
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == word.charAt(0)) {
                    if (helper(0, i, j, board, word)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}