class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans= new ArrayList<>();
        int stream=1;
        int len=target.length;
        int i=0;
        while(i<len && stream<=n){
            ans.add("Push");
            if(stream==target[i]){
                //ans.add("Push");
                i++;
                stream++;
            }else{
                ans.add("Pop");
                stream++;
            }
            
        }
        return ans;
    }
}