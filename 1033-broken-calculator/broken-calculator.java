class Solution {
    public int brokenCalc(int s, int target) {
        if(s==target){
            return 0;
        }
        if(s>target){
            return s-target;

        }
        if(target%2==0){
            return 1+ brokenCalc(s, target/2);
        }
        return 1+brokenCalc(s,target+1);
    }
}