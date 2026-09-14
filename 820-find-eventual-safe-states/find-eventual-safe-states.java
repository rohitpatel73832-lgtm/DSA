class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans= new ArrayList<>();
        List<List<Integer>> adj= new ArrayList<>();
        int n=graph.length;
        int[] in= new int[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            for(int ele: graph[i]){
                adj.get(ele).add(i);
                in[i]++;
            }
        }
        // kahn's Algorithm

        Queue<Integer> q= new LinkedList<>();
        for(int i=0; i<n; i++){
            if(in[i]==0){
                q.add(i);
            }
        }

        while(q.size()>0){
            int front=q.remove();
            ans.add(front);
            for(int ele: adj.get(front)){
                in[ele]--;
                if(in[ele]==0){
                    q.add(ele);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}