class Solution {
    public int minDeletions(String s) {
        int[] freq= new int[26];
        int count=0;
        int n=s.length();
        HashSet<Integer> st= new HashSet<>();
        for(int i=0; i<n; i++){
            char ch=s.charAt(i);
            int idx=ch-'a';
            freq[idx]++;
        }
        for(int i=0;i<26;i++){
             if (freq[i] == 0) {
                continue;
            }
            while (st.contains(freq[i]) && freq[i] > 0) {
                freq[i]--;
                count++;
            }
            st.add(freq[i]);
        }
        return count;
    }
}