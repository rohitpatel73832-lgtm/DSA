class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        int n=nums.length;
        int i=0;
        while(pq.size()!=k){
            pq.add(nums[i]);
            i++;
        }
        while(i<n){
            pq.add(nums[i]);
            pq.remove();
            i++;
        }
        return pq.peek();
    }
}