class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            st.push(ch);

            if (st.size() >= part.length()) {
                boolean found = true;

                for (int i = 0; i < part.length(); i++) {
                    if (st.get(st.size() - part.length() + i) != part.charAt(i)) {
                        found = false;
                        break;
                    }
                }

                if (found) {
                    for (int i = 0; i < part.length(); i++) {
                        st.pop();
                    }
                }
            }
        }

        StringBuilder ans = new StringBuilder();

        for (char ch : st) {
            ans.append(ch);
        }

        return ans.toString();
    }
}