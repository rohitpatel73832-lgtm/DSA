class Solution {
    public double possible(int[] dist, int midSpeed){
        double time=0.0;
        int n=dist.length;
        for(int i=0; i<n-1; i++){
            double t=(double) dist[i]/midSpeed;
            time+=Math.ceil(t);
        }
        time+=(double) dist[n-1]/(double)midSpeed;
        return time;
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        int l=1;
        int r=10000007;
        int result=-1;
        while(l<=r){
            int midSpeed=l+(r-l)/2;

            if(possible(dist,midSpeed)<=hour){
                result=midSpeed;
                r=midSpeed-1;
            }else{
                l=midSpeed+1;
            }
        }
        return result;
    }
}