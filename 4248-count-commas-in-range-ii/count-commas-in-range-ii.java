class Solution {
    public long countCommas(long n) {
        long original = n;
        int count=0;
        long ans=0;
        while(n > 0) {
            long digit = n % 10;
            count++;
            n = n / 10;
        }

        if(count<=3) return 0;

        if(count>3 && count<=6){
            ans=original-999;
        }else if(count>6 && count<=9){
            ans = (999999 - 999) + (original - 999999) * 2;
        }
        else if(count>9 && count<=12){
            ans = (999999 - 999)
                + (999999999 - 999999) * 2
                + (original - 999999999) * 3;
        }else if (count <= 15) {
            ans = (999999 - 999)
                + (999999999 - 999999) * 2
                + (999999999999L - 999999999) * 3
                + (original - 999999999999L) * 4;
        } 
            else {
                ans = (999999 - 999)
                    + (999999999 - 999999) * 2
                    + (999999999999L - 999999999) * 3
                    + (999999999999999L - 999999999999L) * 4
                    + (original - 999999999999999L) * 5;
            }
        return ans;
    }
}