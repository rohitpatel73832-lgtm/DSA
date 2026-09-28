class Solution {
    public int reverse(int x) {
        int rev = 0;
        int num = x;

        if (num < 0) {
            num = -num;
        }

        while (num > 0) {
            int digit = num % 10;

            if (rev > Integer.MAX_VALUE / 10 ||
                (rev == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }

            rev = rev * 10 + digit;
            num = num / 10;
        }

        if (x < 0) {
            return -1 * rev;
        } else {
            return rev;
        }
    }
}