// class Solution {
//     public int[] dailyTemperatures(int[] temp) {
//         int n=temp.length;
//         int[] nge=new int[n];
//         int[] ans=new int[n];
//         Stack<Integer> st= new Stack<>();
//         nge[n-1]=0;
//         st.push(n-1);
//         for(int i=n-2; i>=0; i--){
//             int p=st.peek();
//             if(temp[i]<temp[p]){

//                 nge[i]=p;
//                 st.push(i);
                
//             }else{
//                 while(st.size()>0){
//                     st.pop();
//                 }
//                 if(st.size()==0){
//                     nge[i]=0;
//                 }
//                 st.push(i);
//             }
            
//         }

//         for(int i=n-1; i>=0; i--){
//             if(nge[i]==0){
//                 ans[i]=0;
//             }
//             ans[i]=i-nge[i];
//         }
//         return ans;
//     }
// }

class Solution {

    public int[] dailyTemperatures(int[] temp) {

        int n = temp.length;

        int[] nge = new int[n];
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        nge[n - 1] = 0;
        st.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {

            // Remove elements which cannot be the
            // next greater temperature
            while (!st.isEmpty() && temp[st.peek()] <= temp[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nge[i] = 0;
            } else {
                nge[i] = st.peek();
            }

            st.push(i);
        }

        for (int i = 0; i < n; i++) {

            if (nge[i] == 0) {
                ans[i] = 0;
            } else {
                ans[i] = nge[i] - i;
            }
        }

        return ans;
    }
}