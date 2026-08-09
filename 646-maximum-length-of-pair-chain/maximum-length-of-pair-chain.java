class Solution {
    public class Pair implements Comparable<Pair>{
        int first;
        int second;

        public Pair(int first, int second){
            this.first=first;
            this.second=second;
        }

        public int compareTo(Pair next){
            return Integer.compare(this.first,next.first);
        }
    } 
    public int findLongestChain(int[][] pairs) {
        int m=pairs.length;
        Pair[] pairList= new Pair[m];
        for(int i=0; i<m; i++){
            pairList[i]=new Pair(pairs[i][0],pairs[i][1]);
        }
        Arrays.sort(pairList);
        int maxChain=1;
        int[] dp= new int[m];
        Arrays.fill(dp,1);
        for(int i=1; i<m; i++){
           for (int j=0; j<i; j++){
            if(pairList[i].first>pairList[j].second){
                dp[i]=Math.max(dp[i],dp[j]+1);
            }
           }
           maxChain=Math.max(maxChain,dp[i]);
        }
        return maxChain;
    }
}