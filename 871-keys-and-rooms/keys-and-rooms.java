class Solution {
    public void bfs(int st,List<List<Integer>> rooms,boolean[] visited){
        Queue<Integer> q= new LinkedList<>();
        q.add(st);
        visited[st]=true;

        while(q.size()>0){
            int front= q.remove();

            for(int ele: rooms.get(front)){
                if(visited[ele]==false){
                    q.add(ele);
                    visited[ele]=true;
                }
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] visited= new boolean[n];
        bfs(0,rooms,visited);
        for(int i=0; i<n; i++){
            if(visited[i]==false) return false;
        }
        return true;
    }
}