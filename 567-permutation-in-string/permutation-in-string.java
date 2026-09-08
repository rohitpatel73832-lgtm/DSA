class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if (n1 > n2) {
            return false;
        }

        HashMap<Character, Integer> mp = new HashMap<>();

        for (int i = 0; i < n1; i++) {
            char ch = s1.charAt(i);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        int j = 0;
        int count = 0;

        for (int i = 0; i < n2; i++) {

            char ch = s2.charAt(i);

            if (mp.containsKey(ch)) {
                if (mp.get(ch) > 0) {
                    count++;
                }

                mp.put(ch, mp.get(ch) - 1);
            }

            while (i - j + 1 > n1) {

                char c = s2.charAt(j);

                if (mp.containsKey(c)) {
                    mp.put(c, mp.get(c) + 1);

                    if (mp.get(c) > 0) {
                        count--;
                    }
                }

                j++;
            }

            if (count == n1) {
                return true;
            }
        }

        return false;
    }
}