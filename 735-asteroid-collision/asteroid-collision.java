class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st= new Stack<>();
        for (int ele : asteroids) {

            while (!st.isEmpty() && st.peek() > 0 && ele < 0) {

                if (st.peek() < -ele) {
                    // stack asteroid is smaller
                    st.pop();
                }
                else if (st.peek() == -ele) {
                    // both explode
                    st.pop();
                    ele = 0;
                    break;
                }
                else {
                    // current asteroid is smaller
                    ele = 0;
                    break;
                }
            }

            if (ele != 0) {
                st.push(ele);
            }
        }

        int[] ans=new int[st.size()];
        for(int i=st.size()-1; i>=0; i--){
            ans[i]=st.pop();
        }
        return ans;
    }
}
