class Solution {
    static boolean ans;

    public void bfs(int i, List<List<Integer>> adj, int[] vis) {

        Queue<Integer> q = new LinkedList<>();

        vis[i] = 0; // 0 = red, 1 = blue
        q.add(i);

        while(q.size() > 0) {

            int front = q.remove();

            int color = vis[front];

            for(int ele : adj.get(front)) {

                // same color
                if(vis[ele] == vis[front]) {
                    ans = false;
                    return;
                }

                // not visited
                if(vis[ele] == -1) {
                    vis[ele] = 1 - color;
                    q.add(ele);
                }
            }
        }
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        int m = dislikes.length;

        for(int i = 0; i < m; i++) {

            int u = dislikes[i][0];
            int v = dislikes[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] vis = new int[n + 1];

        Arrays.fill(vis, -1);

        ans = true;

        for(int i = 1; i <= n; i++) {

            if(ans == false) {
                return ans;
            }

            if(vis[i] == -1) {
                bfs(i, adj, vis);
            }
        }

        return ans;
    }
}