class Solution {

    public class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int bfs(Queue<Pair> q, int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        while (q.size() > 0) {

            int size = q.size();

            while (size-- > 0) {

                Pair front = q.remove();

                int rw = front.row;
                int cl = front.col;

                // up
                if (rw - 1 >= 0 && grid[rw - 1][cl] == 1) {
                    grid[rw - 1][cl] = 2;
                    q.add(new Pair(rw - 1, cl));
                }

                // bottom
                if (rw + 1 < m && grid[rw + 1][cl] == 1) {
                    grid[rw + 1][cl] = 2;
                    q.add(new Pair(rw + 1, cl));
                }

                // left
                if (cl - 1 >= 0 && grid[rw][cl - 1] == 1) {
                    grid[rw][cl - 1] = 2;
                    q.add(new Pair(rw, cl - 1));
                }

                // right
                if (cl + 1 < n && grid[rw][cl + 1] == 1) {
                    grid[rw][cl + 1] = 2;
                    q.add(new Pair(rw, cl + 1));
                }
            }

            if (q.size() > 0) {
                count++;
            }
        }

        return count;
    }

    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        int fresh = 0;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int time = bfs(q, grid);

        // Check if fresh oranges are remaining
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return time;
    }
}