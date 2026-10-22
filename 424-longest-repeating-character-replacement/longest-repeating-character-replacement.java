class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();

        int l = 0;
        int r = 0;
        int mxLen = 0;
        int maxFreq = 0;

        while (r < n) {
            char ch = s.charAt(r);

            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(ch));

            if ((r - l + 1) - maxFreq <= k) {
                mxLen = Math.max(mxLen, r - l + 1);
            } else {
                char leftChar = s.charAt(l);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                l++;
            }

            r++;
        }

        return mxLen;
    }
}