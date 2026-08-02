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

    TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        // Traverse left subtree
        if (!isValidBST(root.left))
            return false;
        // Current node must be greater than previous node
        if (prev != null && root.val <= prev.val)
            return false;
        prev = root;
       // Traverse right subtree
        return isValidBST(root.right);
    }
}