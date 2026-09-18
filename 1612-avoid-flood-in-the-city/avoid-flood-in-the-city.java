class Solution {
    public int[] avoidFlood(int[] rains) {

        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> dryDays = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (rains[i] == 0) {

                // store dry day
                dryDays.add(i);

            } else {

                int lake = rains[i];

                // lake already has water
                if (map.containsKey(lake)) {

                    int prev = map.get(lake);

                    // find a dry day after prev
                    int dryDay = -1;

                    for (int j = 0; j < dryDays.size(); j++) {

                        if (dryDays.get(j) > prev) {
                            dryDay = dryDays.get(j);
                            dryDays.remove(j);
                            break;
                        }
                    }

                    // no dry day available
                    if (dryDay == -1) {
                        return new int[0];
                    }

                    ans[dryDay] = lake;
                }

                // update last rain day
                map.put(lake, i);

                ans[i] = -1;
            }
        }

        return ans;
    }
}