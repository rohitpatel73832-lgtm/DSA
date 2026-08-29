class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int[] merged= new int[m+n];
        int i=0;
        int j=0;
        while(i<n){
            merged[i]=nums1[i];
            i++;
        }
        while(j<m){
            merged[i]=nums2[j];
            i++;
            j++;
        }

        Arrays.sort(merged);

        int ml = merged.length;

        if (ml % 2 != 0) {
            return (double) merged[ml / 2];
        } else {
            return ((double) merged[ml / 2] + merged[ml / 2 - 1]) / 2;
        }
       
    }
}