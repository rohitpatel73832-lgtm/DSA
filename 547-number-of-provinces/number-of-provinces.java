class Solution {
    public void bfs(int st,int[][] isConnected,boolean[] visited){
        int n=isConnected.length;
        Queue<Integer> q= new LinkedList<>();
        q.add(st);
        visited[st]=true;

        while(q.size()>0){
            int front=q.remove();

            for(int j=0; j<n; j++){
                if(isConnected[front][j]==1 && visited[j]==false){
                    q.add(j);
                    visited[j]=true;
                }
            }
        }
        
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] visited= new boolean[n];
        int count=0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                bfs(i,isConnected,visited);
                count++;
            }
            
        }
        return count;
    }
}