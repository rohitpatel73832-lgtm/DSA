class Solution {
    public int partitionString(String s) {
        HashSet<Character> st= new HashSet<>();
        int n=s.length();
        int count=1;
        for(int i = 0; i < n; i++) {
            if(st.contains(s.charAt(i))) {
                count++;
                st.clear();
            }

            st.add(s.charAt(i));
        }

        return count;
    }
}