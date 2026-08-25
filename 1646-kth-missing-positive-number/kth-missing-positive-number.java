class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n=arr.length;
        Set<Integer> st= new HashSet<>();
        for(int i=0; i<n; i++){
            st.add(arr[i]);
        }
        int endDigit=arr[n-1];
        int count=0;
        //int loop=Math.max(2*endDigit,2*n);
        for(int i=1; i<=5*endDigit; i++){
            
            if(!st.contains(i)){
                count++;
                if(count==k) return i;
            }
        }
        return 0;
    }
}