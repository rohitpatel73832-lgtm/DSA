class Solution {
    public boolean validateStackSequences(int[] pu, int[] po) {
        int n = pu.length;

        Stack<Integer> st = new Stack<>();
        int j = 0;

        for (int i = 0; i < n; i++) {

            st.push(pu[i]);

            while (!st.isEmpty() && st.peek() == po[j]) {
                st.pop();
                j++;

                if (j == n) {
                    break;
                }
            }
        }

        return st.isEmpty();
    }
}