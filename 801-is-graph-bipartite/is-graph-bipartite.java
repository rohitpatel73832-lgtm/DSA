class Solution {
    boolean ans = true;
    public void bfs(int i, int[][] graph, int[] vis){
        Queue<Integer> q= new LinkedList<>();
        vis[i]=0;
        q.add(i);
        while(q.size()>0){
            int front=q.remove();
            int color=vis[front]; //0-> red, 1 -> blue
            for(int ele: graph[front]){
                if(vis[ele]==vis[front]){
                    ans= false;
                    return;
                }
                if(vis[ele]==-1){
                    vis[ele]=1-color;
                    q.add(ele);
                }
            }
        }
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] vis= new int[n];
        Arrays.fill(vis,-1);
        for(int i=0; i<n; i++){
            if(vis[i]==-1){
                bfs(i,graph,vis);
            }
        }
        return ans;
    }
}