class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> st = new HashSet<>();

        int mxLen = 0;
        int l = 0;
        int r = 0;

        while (r < n) {
            char ch = s.charAt(r);

            if (!st.contains(ch)) {
                st.add(ch);
                mxLen = Math.max(mxLen, r - l + 1);
                r++;
            } else {
                while (st.contains(ch)) {
                    st.remove(s.charAt(l));
                    l++;
                }
            }
        }

        return mxLen;
    }
}