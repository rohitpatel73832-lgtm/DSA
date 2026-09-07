class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n=s.length();
        int l=0;
        int r=0;
        int cost=0;
        int mxCost=0;
        while(r<n){
            int a=s.charAt(r)-'a';
            int b=t.charAt(r)-'a';
            int diff=a-b;
            cost+=Math.abs(diff);
            
            while(cost>maxCost){
                int c=s.charAt(l)-'a';
                int d=t.charAt(l)-'a';
                int diiff=c-d;
                cost-=Math.abs(diiff);
                l++;
            }
            mxCost = Math.max(mxCost, r - l + 1);
            r++;
        }
        return mxCost;
    }
}