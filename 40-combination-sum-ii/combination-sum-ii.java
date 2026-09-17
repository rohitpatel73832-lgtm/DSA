// class Solution {
//     public void helper(int[] candidates, int target, int st, int sum,List<Integer> adj, List<List<Integer>> combine) {      

//         if (sum == target) {
//             combine.add(new ArrayList<>(adj));
//             return;
//         }

//         if (st >= candidates.length || sum > target) {
//             return;
//         }

//         // take
//         adj.add(candidates[st]);

//         helper(candidates, target, st + 1,
//                sum + candidates[st], adj, combine);

//         // backtrack
//         adj.remove(adj.size() - 1);

//         // skip
//         helper(candidates, target, st + 1,
//                sum, adj, combine);
//     }

//     public List<List<Integer>> combinationSum2(int[] candidates, int target) {

//         List<List<Integer>> combine = new ArrayList<>();
//         List<Integer> adj = new ArrayList<>();
//         // Arrays.sort(candidates); 

//         helper(candidates, target, 0, 0, adj, combine);
//         return combine;

//         // Set<List<Integer>> st = new HashSet<>();

//         // for (List<Integer> ele : combine) {
//         //     st.add(ele);
//         // }

//         // return new ArrayList<>(st);
//     }
// }

class Solution {

    public void helper(int[] candidates, int target, int st, int sum,
                       List<Integer> adj, List<List<Integer>> combine) {

        if (sum == target) {
            combine.add(new ArrayList<>(adj));
            return;
        }

        if (st >= candidates.length || sum > target) {
            return;
        }

        // take
        adj.add(candidates[st]);

        helper(candidates, target, st + 1,
               sum + candidates[st], adj, combine);

        // backtrack
        adj.remove(adj.size() - 1);

        // skip
        int next = st + 1;

        // skip duplicate values
        while (next < candidates.length &&
               candidates[next] == candidates[st]) {
            next++;
        }

        helper(candidates, target, next, sum, adj, combine);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> combine = new ArrayList<>();
        List<Integer> adj = new ArrayList<>();

        helper(candidates, target, 0, 0, adj, combine);

        return combine;
    }
}