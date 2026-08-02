class Solution {
    public boolean helper(int i, int j, int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n)
            return false;

        if (matrix[i][j] == target)
            return true;

        if (matrix[i][j] > target)
            return helper(i, j - 1, matrix, target);

        return helper(i + 1, j, matrix, target);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;

        // Start from top-right corner
        return helper(0, n - 1, matrix, target);
    }
}