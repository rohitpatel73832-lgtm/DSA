class Solution {
    boolean ans;
    public void dfs(int i,List<List<Integer>> adj,boolean[] vis,boolean[] path){
        vis[i]=true;
        path[i]=true;
        for(int ele: adj.get(i)){
            if(path[ele]==true){
                ans=false;//there is cycle
                return;
            }
            if(vis[ele]==false)dfs(ele,adj,vis,path);
        }
        path[i]=false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ans=true; //means no cycle
        List<List<Integer>> adj= new ArrayList<>();
        //int[] indegree= new int[numCourses];
        boolean[] vis= new boolean[numCourses];
        boolean[] path= new boolean[numCourses];
        for(int i=0;i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<prerequisites.length; i++){
            int a=prerequisites[i][0];
            int b=prerequisites[i][1];
            adj.get(b).add(a);
            //indegree[a]++;
        }
        for(int i=0; i<numCourses; i++){
           if(vis[i]==false) dfs(i,adj,vis,path);
        }
        return ans;

        // //kahn's Algorithm
        // Queue<Integer> q= new LinkedList<>();
        // List<Integer> ans= new ArrayList<>();
        // for(int i=0; i<numCourses; i++){
        //     if(indegree[i]==0){
        //         q.add(i);
        //     }
        // }

        // while(q.size()>0){
        //     int front=q.remove();
        //     ans.add(front);
        //     for(int ele: adj.get(front)){
        //         indegree[ele]--;
        //         if(indegree[ele]==0){
        //             q.add(ele);
        //         }
        //     }
        // }
        // return ans.size()==numCourses? true: false;
    }
}