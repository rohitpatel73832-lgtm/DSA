// class Solution {
//     public int[] nextGreaterElements(int[] nums) {
//         int n=nums.length;
//         int[] nge= new int[n];
//         // int[] pge= new int[n];
//         int[] ans= new int[n];
//         Stack<Integer> st= new Stack<>();
//         for(int i=n-2;i>=0; i--){
//             st.push(nums[i]);
//         }
//     //    nge[n - 1] = -1;
//     //     st.push(n - 1);

//       for (int i = n - 2; i >= 0; i--) {

//        while (!st.isEmpty() && nums[i] >= nums[st.peek()]) {
//         st.pop();
//       }

//       if (st.isEmpty()) {
//         nge[i] = -1;
//       }   else {
//         nge[i] = nums[st.peek()];
//       }

//      st.push(i);
// }

// //         // Previous Greater Element
// //      st.clear();

// //     pge[0] = -1;
// //     st.push(0);

// //     for (int i = 1; i < n; i++) {

// //     while (!st.isEmpty() && nums[i] >= nums[st.peek()]) {
// //         st.pop();
// //     }

// //     if (st.isEmpty()) {
// //         pge[i] = -1;
// //     } else {
// //         pge[i] = nums[st.peek()];
// //     }

// //     st.push(i);
// // }

// //         //filling answer array
// //         int ngeM=Integer.MIN_VALUE;
// //         int pgeM=Integer.MIN_VALUE;
// //         for (int i = 0; i < n; i++) {
// //             ngeM=Math.max(ngeM,nge[i]);
// //             pgeM=Math.max(pgeM,pge[i]);
// //             if (nge[i] != -1) {
// //                 ans[i] = nge[i];
// //             } else if(nge[i]==-1){
// //                 ans[i]=Math.max(ngeM,pgeM);
// //             }else{
// //                 ans[i]=Math.max(nge[i],pge[i]);
// //             }

                
// //         }

//         return ans;
//     }
// }

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] nge = new int[n];

        Stack<Integer> st = new Stack<>();

        // Put circular elements into stack
        for (int i = n - 1; i >= 0; i--) {
            st.push(nums[i]);
        }

        // Find NGE
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && nums[i] >= st.peek()) {
                st.pop();
            }

            if (st.isEmpty()) {
                nge[i] = -1;
            } else {
                nge[i] = st.peek();
            }

            st.push(nums[i]);
        }

        return nge;
    }
}