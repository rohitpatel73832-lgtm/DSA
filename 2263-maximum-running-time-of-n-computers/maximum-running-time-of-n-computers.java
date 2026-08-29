class Solution {
    public long sumFind(int[] batteries){
        int n=batteries.length;
        long sum=0;
        for(int i=0; i<n; i++){
            sum+=batteries[i];
        }
        return sum;
    }
    public boolean possible(int n, int[] batteries, long time) {
        long total = 0;

        for (int battery : batteries) {
            total += Math.min((long) battery, time);
        }

        return total >= (long) n * time;
    }

    public long maxRunTime(int n, int[] batteries) {

        long l = 0;
        long r = sumFind(batteries) ;

        long ans = 0;

        while (l <= r) {

            long mid = l + (r - l) / 2;

            if (possible(n, batteries, mid)) {
                ans = mid;
                l = mid + 1;   
            } else {
                r = mid - 1;   
            }
        }
        return ans;
    }
}