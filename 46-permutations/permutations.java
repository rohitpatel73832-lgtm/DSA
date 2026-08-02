class Solution {
    public void helper(int[] nums,boolean[] isVisited,List<Integer> ds,List<List<Integer>> ans){
        if(ds.size()==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(isVisited[i]==false){
                ds.add(nums[i]);
                isVisited[i]=true;
                helper(nums,isVisited,ds,ans);
                isVisited[i]=false;
                ds.remove(ds.size()-1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        boolean[] isVisited= new boolean[nums.length];
        helper(nums,isVisited,ds,ans);
        return ans;
    }
}