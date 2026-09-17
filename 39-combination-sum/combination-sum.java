class Solution {
    public void helper(int[] candidates, int target,int st,int sum,List<Integer> adj,List<List<Integer>> ans){
        if (sum == target) {
            ans.add(new ArrayList<>(adj));
            return;
        }

        if (st >= candidates.length || sum > target) {
            return;
        }

        adj.add(candidates[st]);
        helper(candidates, target, st, sum + candidates[st], adj, ans);


        // backtrack
        adj.remove(adj.size() - 1);

         // skip
        helper(candidates, target, st + 1, sum, adj, ans);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> adj = new ArrayList<>();
        helper(candidates,target,0,0,adj,ans);
        return ans;
    }
}