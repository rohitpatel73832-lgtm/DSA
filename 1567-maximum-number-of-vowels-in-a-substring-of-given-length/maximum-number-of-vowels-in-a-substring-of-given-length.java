class Solution {
    public int maxVowels(String s, int k) {
        String v = "aeiou";
        int count = 0;
        // Count vowels in the first window
        for (int i = 0; i < k; i++) {
            if (v.indexOf(s.charAt(i)) != -1) {
                count++;
            }
        }
        int ans = count;
        // Slide the window
        for (int i = k; i < s.length(); i++) {
            // Remove the leftmost character
            if (v.indexOf(s.charAt(i - k)) != -1) {
                count--;
            }
            // Add the new rightmost character
            if (v.indexOf(s.charAt(i)) != -1) {
                count++;
            }

            ans = Math.max(ans, count);
        }

        return ans;
    }
}