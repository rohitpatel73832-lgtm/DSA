class Solution {
    public int minSwaps(String s) {
        Stack<Character> st = new Stack<>();
        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(st.size() > 0 && st.peek() == '[' && ch == ']') {
                st.pop();
            } else {
                st.push(ch);

                if(ch == ']') {
                    count++;
                }
            }
        }

        return (count + 1) / 2;
    }
}