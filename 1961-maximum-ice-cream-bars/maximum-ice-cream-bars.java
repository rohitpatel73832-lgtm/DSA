class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n=costs.length;
        Arrays.sort(costs);
        if(costs[0]>coins) return 0;
        int iceCreams=0;
        for(int i=0; i<n; i++){
            if(costs[i] > coins) {
                break;
            }
            coins=coins-costs[i];
            iceCreams++;       
        }
                
        return iceCreams++;
    }
}