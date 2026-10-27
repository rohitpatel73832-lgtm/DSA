class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        int[] dup = new int[n];
        int[] ans= new int[n];
        for(int i=0; i<n; i++){
            dup[i]=arr[i];
        }
        Arrays.sort(dup);
        Map<Integer, Integer> mp= new HashMap<>();
        int rank=1;
        for(int i=0; i<n; i++){
            if(!mp.containsKey(dup[i])){
                mp.put(dup[i],rank);
                rank++;
            }
        }

        for(int i=0; i<n; i++){
            ans[i]=mp.get(arr[i]);
        }
        return ans;
    }
}