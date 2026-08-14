class Solution {
    int ans = 0;
    public void helper(TreeNode root, int state, int count) {

        if (root == null) {
            return;
        }

        ans = Math.max(ans, count);

        if (state == 0) {
            // We came from LEFT, so next should be RIGHT
            helper(root.right, 1, count + 1);

            // Start a new ZigZag from left child
            helper(root.left, 0, 1);

        } else {
            // We came from RIGHT, so next should be LEFT
            helper(root.left, 0, count + 1);

            // Start a new ZigZag from right child
            helper(root.right, 1, 1);
        }
    }

    public int longestZigZag(TreeNode root) {

        if (root == null) {
            return 0;
        }

        helper(root.left, 0, 1);
        helper(root.right, 1, 1);

        return ans;
    }
}