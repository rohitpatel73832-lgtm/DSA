class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n=happiness.length;
        long ans=0;
        long count=0;
        Arrays.sort(happiness);
        for(int i=n-1; i>=0; i--){
            if(happiness[i]-count>=0 && k>0){
                ans+=happiness[i]-count;
                count++;
            }
            
            
            k--;
        }
        return ans;
    }
}