class Solution {
    public int minimumDeletions(String s) {

        int b = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == 'b') {
                b++;
            }
            else {
                if (b > 0) {
                    count++;
                    b--;
                }
            }
        }

        return count;
    }
}