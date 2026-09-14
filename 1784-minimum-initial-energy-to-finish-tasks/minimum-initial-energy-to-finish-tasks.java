class Solution {
    public boolean isPossible(int[][] tasks, int mid){
        int n=tasks.length;
        int middle=mid;
        for (int i = 0; i < n; i++) {
            int min = tasks[i][1];
            int act = tasks[i][0];

            if (middle >= min) {
                middle = middle - act;
            } else {
                return false;
            }
        }
        // if(middle>=0){
        //     return true;
        // }
        return true;
    }
    public int minimumEffort(int[][] tasks) {
        int m=tasks.length;
        Arrays.sort(tasks, (a, b) ->
            Integer.compare((b[1] - b[0]), (a[1] - a[0]))
        );

        int l=0;
        int r=1000000009;
        int ans=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(isPossible(tasks,mid)){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}