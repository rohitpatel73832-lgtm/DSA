class Solution {

    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int nearestExit(char[][] maze, int[] entrance) {

        int m = maze.length;
        int n = maze[0].length;

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(entrance[0], entrance[1]));
        maze[entrance[0]][entrance[1]] = '+';

        int distance = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            distance++;

            for (int i = 0; i < size; i++) {

                Pair curr = q.remove();

                int row = curr.row;
                int col = curr.col;

                // UP
                if (row > 0 && maze[row - 1][col] == '.') {

                    int nr = row - 1;
                    int nc = col;

                    if (nr == 0 || nr == m - 1 ||
                        nc == 0 || nc == n - 1) {
                        return distance;
                    }

                    maze[nr][nc] = '+';
                    q.add(new Pair(nr, nc));
                }

                // DOWN
                if (row < m - 1 && maze[row + 1][col] == '.') {

                    int nr = row + 1;
                    int nc = col;

                    if (nr == 0 || nr == m - 1 ||
                        nc == 0 || nc == n - 1) {
                        return distance;
                    }

                    maze[nr][nc] = '+';
                    q.add(new Pair(nr, nc));
                }

                // LEFT
                if (col > 0 && maze[row][col - 1] == '.') {

                    int nr = row;
                    int nc = col - 1;

                    if (nr == 0 || nr == m - 1 ||
                        nc == 0 || nc == n - 1) {
                        return distance;
                    }

                    maze[nr][nc] = '+';
                    q.add(new Pair(nr, nc));
                }

                // RIGHT
                if (col < n - 1 && maze[row][col + 1] == '.') {

                    int nr = row;
                    int nc = col + 1;

                    if (nr == 0 || nr == m - 1 ||
                        nc == 0 || nc == n - 1) {
                        return distance;
                    }

                    maze[nr][nc] = '+';
                    q.add(new Pair(nr, nc));
                }
            }
        }

        return -1;
    }
}