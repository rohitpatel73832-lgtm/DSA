class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int n = grumpy.length;
        int l = 0;
        int r = 0;
        int mxUnCus = 0;
        int unSatC = 0;

        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                unSatC += customers[i];
            }
        }

        // First window
        for (int i = 0; i < minutes; i++) {
            mxUnCus += customers[i] * grumpy[i];
        }

        int curr = mxUnCus;

        r = minutes;

        while (r < n) {

            // Add right element
            curr += customers[r] * grumpy[r];

            // Remove left element
            curr -= customers[l] * grumpy[l];

            mxUnCus = Math.max(mxUnCus, curr);

            l++;
            r++;
        }

        return unSatC + mxUnCus;
    }
}