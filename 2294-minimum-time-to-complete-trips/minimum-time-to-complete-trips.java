class Solution {

    public boolean possible(int[] time, long givenTime, int totalTrips) {
        long actualTrips = 0;

        for (int t : time) {
            actualTrips += givenTime / t;
            if (actualTrips >= totalTrips) {
                return true;
            }
        }

        return false;
    }

    public int minElement(int[] time) {
        int min = Integer.MAX_VALUE;

        for (int t : time) {
            if (t < min) {
                min = t;
            }
        }

        return min;
    }

    public long minimumTime(int[] time, int totalTrips) {

        long l = 1;
        long r = (long) totalTrips * minElement(time);

        while (l < r) {

            long mid = l + (r - l) / 2;

            if (possible(time, mid, totalTrips)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}