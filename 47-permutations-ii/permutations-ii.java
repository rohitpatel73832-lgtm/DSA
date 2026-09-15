class Solution {
    public void helper(int[] nums,List<Integer> ds,boolean[] isVisited,List<List<Integer>> ans){
        if(ds.size()==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0; i<nums.length; i++){
            // if(ds.contains(nums[i])){
            //     continue;
            // }
            // ds.add(nums[i]);
            // helper(nums,ds,ans);
            // ds.remove(ds.size()-1);
             if (i > 0 && nums[i] == nums[i - 1] && !isVisited[i - 1]) {
                continue;
            }
            if(isVisited[i]==false){
                ds.add(nums[i]);
                isVisited[i]=true;
                helper(nums,ds,isVisited,ans);
                
                ds.remove(ds.size()-1);
                isVisited[i]=false;
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
         Arrays.sort(nums);
        boolean[] isVisited= new boolean[nums.length];
        helper(nums,ds,isVisited,ans);
        return ans;
    }
}