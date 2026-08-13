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
// class Solution {
//     public int countNodes(TreeNode root) {
//         if(root==null) return 0;
//         int lh=countNodes(root.left);
//         int rh=countNodes(root.right);
//         int ans=lh+rh;
//         return 1+ans;
//     }
// }

class Solution {

    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int lh = getLeftHeight(root);
        int rh = getRightHeight(root);

        // Perfect binary tree
        if (lh == rh) {
            return (1 << lh) - 1;
        }

        // Not perfect, recursively count
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int getLeftHeight(TreeNode root) {
        int h = 0;

        while (root != null) {
            h++;
            root = root.left;
        }

        return h;
    }

    public int getRightHeight(TreeNode root) {
        int h = 0;

        while (root != null) {
            h++;
            root = root.right;
        }

        return h;
    }
}