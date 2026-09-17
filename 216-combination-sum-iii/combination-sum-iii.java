class Solution {
    public void helper(int k, int n,int sum, List<Integer> adj,List<List<Integer>> ans,int i){
        
         if (k == 0) {
            if (sum == n) {
                ans.add(new ArrayList<>(adj));
            }
            return;
        }
        if (i > 9 || sum > n) {
            return;
        }

        //take
        adj.add(i);
        helper(k-1,n,sum+i,adj,ans,i+1);

        //backtrack
        adj.remove(adj.size()-1);

        //skip
        helper(k,n,sum,adj,ans,i+1);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> adj= new ArrayList<>();
        helper(k,n,0,adj,ans,1);
        return ans;
    }
}