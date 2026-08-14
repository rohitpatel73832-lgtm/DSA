
class Solution {
    public String helper(TreeNode root,HashMap<String, Integer> mp,List<TreeNode> ans) {
                         
          if (root == null) {
            return "N";
        }

        String left = helper(root.left, mp, ans);
        String right = helper(root.right, mp, ans);

        String key = root.val + "," + left + "," + right;

        int count = mp.getOrDefault(key, 0);

        if (count == 1) {
            ans.add(root);
        }

        mp.put(key, count + 1);

        return key;
    } 
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, Integer> mp = new HashMap<>();
        List<TreeNode> ans = new ArrayList<>();
        helper(root, mp, ans);
        return ans;
    }
}