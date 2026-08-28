class Solution {
    public boolean canEat(int[] piles,int mid, int h){
        int actualHours=0;
        for(int x:piles){
            actualHours+=x/mid;
            if(x%mid!=0){
                actualHours++;
            }
        }
        return actualHours<=h;
    }
    public int maximum(int[] piles){
        int max=Integer.MIN_VALUE;
        for(int i=0; i<piles.length; i++){
            if(piles[i]>max){
                max=piles[i];
            }
        }
        return max;

    }
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int l=1;
        int r=maximum(piles);
        while(l<r){
            int mid=l+(r-l)/2;
            if(canEat(piles,mid,h)){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
}