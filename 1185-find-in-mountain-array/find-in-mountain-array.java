class Solution {

    public int findPeak(MountainArray mountainArr) {

        int l = 0;
        int r = mountainArr.length() - 1;

        while (l < r) {

            int mid = l + (r - l) / 2;

            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                r = mid;
            } 
            else {
                l = mid + 1;
            }
        }

        return l;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {

        int n = mountainArr.length();

        int peakIdx = findPeak(mountainArr);

        int l = 0;
        int r = peakIdx;

        // Search ascending (left side)
        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (mountainArr.get(mid) == target) {
                return mid;
            } 
            else if (mountainArr.get(mid) < target) {
                l = mid + 1;
            } 
            else {
                r = mid - 1;
            }
        }

        // Search right side (decreasing)
        l = peakIdx + 1;
        r = n - 1;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (mountainArr.get(mid) == target) {
                return mid;
            } 
            else if (mountainArr.get(mid) < target) {
                r = mid - 1;
            } 
            else {
                l = mid + 1;
            }
        }

        return -1;
    }
}