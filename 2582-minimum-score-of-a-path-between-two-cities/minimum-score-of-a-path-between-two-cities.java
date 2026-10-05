class Solution {
    public class Pair{
        int node;
        int dist;

        Pair(int node, int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public int minScore(int n, int[][] roads) {
        List<List<Pair>> adj= new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        int m=roads.length;
        for(int i=0; i<m; i++){
            int u=roads[i][0];
            int v=roads[i][1];
            int wt=roads[i][2];

            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }

        boolean[] vis= new boolean[n+1];
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(1, Integer.MAX_VALUE));
        vis[1]=true;
        int ans=Integer.MAX_VALUE;
        while(q.size()>0){

            Pair front=q.remove();
            int node=front.node;
            int d=front.dist;

            for(Pair ele: adj.get(node)){
                ans = Math.min(ans, ele.dist);
                if(!vis[ele.node]) {
                    vis[ele.node] = true;
                    q.add(new Pair(ele.node, ele.dist));
                }
                
            }
            
        }
        return ans;
    }
}