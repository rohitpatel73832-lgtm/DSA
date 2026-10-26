class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int ele: stones){
            pq.add(ele);
        }
        while(pq.size()>1){
            int x= pq.remove();
            int y= pq.remove();
            if(x!=y){
                if(x>y){
                    int temp=x-y;
                    pq.add(temp);
                }
                else{
                    int temp=y-x;
                    pq.add(temp);
                }
            }
        }
        if(pq.size()>0) return pq.peek();
        else return 0;
    }
}