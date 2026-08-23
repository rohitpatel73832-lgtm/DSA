class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()==k) return "0";
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < num.length(); i++) {

            int ch = num.charAt(i) - '0';

            while (k > 0 && st.size() > 0 && st.peek() > ch) {
                st.pop();
                k--;
            }

            st.push(ch);
        }

        // If k is still remaining, remove from the end
        while (k > 0) {
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while (st.size() > 0) {
            sb.append(st.pop());
        }

        String ans = sb.reverse().toString();

        // Remove leading zeroes
        int i = 0;

        while (i < ans.length() - 1 && ans.charAt(i) == '0') {
            i++;
        }

        ans = ans.substring(i);

        return ans;
    }
}