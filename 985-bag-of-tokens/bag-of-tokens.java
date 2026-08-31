class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int n=tokens.length;
        int score=0;
        int mxScore=0;
        int i=0; 
        int j=n-1;
        while(i<=j){
            if(tokens[i]<=power){
                power=power-tokens[i];
                score++;
                mxScore=Math.max(mxScore,score);
                i++;
            }else if (score > 0) {
                power = power + tokens[j];
                score--;
                j--;

            }else{
                break;
            }
        }
        return mxScore;
    }
}
