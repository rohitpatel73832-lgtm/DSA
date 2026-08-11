/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void helper(int level, TreeNode root, List<Integer> ans){
        if(root==null) return;
        if(ans.size()==level){
            ans.add(root.val);
        }
        helper(level+1,root.right,ans);
        helper(level+1,root.left,ans);
    }

    

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans= new ArrayList<>();
        helper(0,root,ans);
        return ans;
    }
}