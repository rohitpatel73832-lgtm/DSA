// class Solution {
//     public double myPow(double x, int n) {
//         // double ans=Math.pow(x,n);
//         // return ans;
//         double ans=1;
//         if(n>0){
//         for(int i=1; i<=n; i++){
//             ans*=x;
//         }
//         }
//         if(n<0){
//            for(int i=0; i>n; i--){
//             ans/=x;
//         }
//         }
//         return ans;
        
//     }
// }

 class Solution {
    public double helper(double x,int n){
        if(n==1){
            return x;
        }
        if(n==0){
            return 1;
        }
        if(n<0){

            if(n==Integer.MIN_VALUE){
                return 1/(x*helper(x,Integer.MAX_VALUE));
            }
            n=-1*n;
            return 1/helper(x,n);
        }
        if(n%2==0){
            double temp=helper(x,n/2);
            return temp * temp;
        }else{
            double temp=helper(x,n/2);
            return x*temp * temp;
        }
    }
    public double myPow(double x, int n) {
        return helper(x,n);
    }
 }