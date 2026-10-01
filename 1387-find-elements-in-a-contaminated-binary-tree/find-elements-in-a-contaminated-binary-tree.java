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
class FindElements {

    TreeNode root;
    public FindElements(TreeNode root) {
        this.root = root;
        if (root == null) {
            return;
        }

        root.val = 0;
        findElements(root);
    }

    public void findElements(TreeNode root) {

        int val = root.val;

        if (root.left != null) {
            root.left.val = 2 * val + 1;
            findElements(root.left);
        }

        if (root.right != null) {
            root.right.val = 2 * val + 2;
            findElements(root.right);
        }
    }


    public boolean find(int target) {
        return search(root, target);
    }

    public boolean search(TreeNode root, int target) {

        if (root == null) {
            return false;
        }

        if (root.val == target) {
            return true;
        }

        return search(root.left, target) ||
               search(root.right, target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */