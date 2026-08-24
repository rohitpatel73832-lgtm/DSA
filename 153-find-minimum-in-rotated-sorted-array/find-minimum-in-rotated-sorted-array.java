class Solution {
    public int findMin(int[] a) {
        int n= a.length;
        int st=0;
        int end=n-1;
        int ans=-1;
        while(st<=end){
            int mid=(st+end)/2;
            if(st==end) return a[st];
            if(a[mid]>=a[st] && a[mid]>a[end]){
                st=mid+1;
            }else{
                end=mid;
            }
        }
        return -1;
        
    }
}