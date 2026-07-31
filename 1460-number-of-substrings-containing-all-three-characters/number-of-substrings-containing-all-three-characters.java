class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int[] freq= new int[3];
        int ans=0;
        int count=0;
        int left=0;
        for(int right=0; right<n; right++){
            char ch=s.charAt(right);
            freq[ch-'a']++;
            if(freq[ch-'a']==1){
                count++;
            }
            while(count==3){
                ans+=n-right;
                char c=s.charAt(left);
                freq[c-'a']--;
                if(freq[c-'a']==0){
                count--;
                }
                left++;
            }
            
        }
        return ans;
    }
}