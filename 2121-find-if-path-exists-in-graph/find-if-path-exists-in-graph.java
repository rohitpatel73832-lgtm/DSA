class Solution {
    public void bfs(int source, int destination, List<List<Integer>> adj, boolean[] vis){
        Queue<Integer> q= new LinkedList<>();
        q.add(source);
        vis[source]=true;

        while(q.size()>0){
            int front= q.remove();

            for(int ele: adj.get(front)){
                if(!vis[ele]){
                    q.add(ele);
                    vis[ele]=true;
                }
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj= new ArrayList<>();
        int m=edges.length;
        boolean[] vis= new boolean[n];
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            int u=edges[i][0];
            int v=edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        bfs(source,destination,adj,vis);

        return vis[destination];
    }
}