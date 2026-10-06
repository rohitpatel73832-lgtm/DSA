class Solution {
    public void dfs(int node,int target,List<List<Integer>> adj,List<Integer> path,List<List<Integer>> ans ){
        if (node == target) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int ele: adj.get(node)){
            path.add(ele);
            dfs(ele, target, adj, path, ans);

            path.remove(path.size() - 1);
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> adj= new ArrayList<>();
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> path= new ArrayList<>();
        int n=graph.length;
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int nei : graph[i]) {
                adj.get(i).add(nei);
            }
        }

        path.add(0);
        dfs(0, n - 1, adj, path, ans);

        return ans;
    }
}