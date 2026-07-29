class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
       int n = s.length();
        int k = p.length();
        int[] freq = new int[26];
       // frequency of pattern p
        for (int i = 0; i < k; i++) {
            int ch = p.charAt(i) - 'a';
            freq[ch]++;
        }
        int i = 0;
        int j = 0;
        int count = k;  // characters still needed

        while (j < n) {
            // include s[j] in window
            int ch = s.charAt(j) - 'a';

            if (freq[ch] > 0) {
                count--;
            }

            freq[ch]--;

            // window size becomes k
            if (j - i + 1 == k) {

                // all characters matched
                if (count == 0) {
                    ans.add(i);
                }

                // remove s[i] from window
                int remove = s.charAt(i) - 'a';

                freq[remove]++;

                if (freq[remove] > 0) {
                    count++;
                }

                i++;
            }

            j++;
        }

        return ans;
    }
}