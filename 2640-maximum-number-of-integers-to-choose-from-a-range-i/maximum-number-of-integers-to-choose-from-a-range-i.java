class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
       Set<Integer> st= new HashSet<>();
       Arrays.sort(banned);
       int count=0;
       for(int ele:banned){
        st.add(ele);
       } 

       int sum=0;
       for(int i=1; i<=n; i++){
         
        if(st.contains(i)){
            continue;
        }else{
            sum=sum+i;
            if(sum<=maxSum){
                count++;
            }else{
                break;
            }
        }
       }
       return count;
    }
}