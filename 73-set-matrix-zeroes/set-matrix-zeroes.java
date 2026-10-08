class Solution {
    public void helper(int i, int j, int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Up
        for(int r = i - 1; r >= 0; r--) {
            if(matrix[r][j] != 0) {
                matrix[r][j] = Integer.MIN_VALUE/2;
            }
        }

        // Down
        for(int r = i + 1; r < m; r++) {
            if(matrix[r][j] != 0) {
                matrix[r][j] = Integer.MIN_VALUE/2;
            }
        }

        // Left
        for(int c = j - 1; c >= 0; c--) {
            if(matrix[i][c] != 0) {
                matrix[i][c] = Integer.MIN_VALUE/2;
            }
        }

        // Right
        for(int c = j + 1; c < n; c++) {
            if(matrix[i][c] != 0) {
                matrix[i][c] = Integer.MIN_VALUE/2;
            }
        }
    }
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){
                    helper(i,j,matrix);
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == Integer.MIN_VALUE/2) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}