class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (int x : arr) {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }

        ArrayList<Integer> freq = new ArrayList<>(mp.values());
        Collections.sort(freq);

        int ans = mp.size();

        for (int f : freq) {
            if (k >= f) {
                k -= f;
                ans--;
            } else {
                break;
            }
        }

        return ans;
    }
}