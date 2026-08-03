class Solution {
    public boolean isValid(int row,int col,char num,char[][] board){
        //check in col
        for(int j=0; j<9; j++){
            if(board[row][j]==num) return false;
        }
        //check in row
        for(int j=0; j<9; j++){
            if(board[j][col]==num) return false;
        }
        //check big box of 3*3
        int r=(row/3)*3;
        int c=(col/3)*3;
        for(int i=r; i<r+3; i++){
            for(int j=c; j<c+3; j++){
                if(board[i][j]==num) return false;
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j]=='.') continue;
                char num=board[i][j];
                board[i][j]='.';
                if(isValid(i,j,num,board)==false) return false;
                board[i][j]=num;
            }
        }
        return true;
    }
}