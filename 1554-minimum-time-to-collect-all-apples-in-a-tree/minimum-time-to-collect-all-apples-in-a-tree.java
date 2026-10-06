class Solution {
    public int dfs(int node, int parent,List<List<Integer>> adj,List<Boolean> hasApple) {
        int time = 0;
        
        for (int ele : adj.get(node)) {
            if (ele == parent) {
                continue;
            }

            int childTime = dfs(ele, node, adj, hasApple);

            // If child subtree has an apple
            if (childTime > 0 || hasApple.get(ele)) {
                time = time + childTime + 2;
            }
        }

        return time;
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj= new ArrayList<>();
        int count=0;
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return dfs(0, -1, adj, hasApple);
    }
}