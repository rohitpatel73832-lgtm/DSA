class Solution {
    public int maxCoins(int[] piles) {
        int n=piles.length;
        Arrays.sort(piles);
        //int first=n-1;
        int second=n-2;
        int third=0;
        int count=0;
        while(third<second){
            count+=piles[second];
            second=second-2;
            third++;
        }
        return count;

    }
}