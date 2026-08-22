class Solution {
    public boolean checkDivisibility(int n) {
        int original=n;
        int sum=0;
        int product=1;
        while(n>0){
            int single=n%10;            
            sum+=single;
            product=product*single;
            n=n/10;
        }
        int ans=sum+product;
        if(original%ans==0){
             return true;
        }else{
            return false;
        }

    }
}