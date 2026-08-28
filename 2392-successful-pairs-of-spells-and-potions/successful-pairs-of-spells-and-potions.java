class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans=new int[spells.length];
        Arrays.sort(potions);
        int n=potions.length;
        
        for(int i=0; i<spells.length; i++){
            int l=0; 
            int r=n-1;
            while(l<r){
                int mid=l+(r-l)/2;
                if((long)spells[i]*potions[mid]>=success){
                    r=mid;
                }else{
                    l=mid+1;
                }
                
            }            
            if ((long) spells[i] * potions[l] >= success) {
                ans[i] = n - l;
            }
            
        }
        return ans;
    }
}