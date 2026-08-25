/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        if(n==1) return 1;
        int l=1;
        int r=n;
        while(l<=r){
            int mid=l+(r-l)/2;
            int val=guess(mid);
            if(val==0) return mid;
            if(val==-1){
                r=mid-1;
            }
            if(val==1){
                l=mid+1;
            }
        }
        return 0;
    }
}