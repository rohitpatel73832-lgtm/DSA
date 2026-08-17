class Solution {
    int ans = 0;
    int maxLevel = -1;

    public void helper(TreeNode root, int level) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (level > maxLevel) {
                maxLevel = level;
                ans = root.val;
            }
            return;
        }

        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }

    public int findBottomLeftValue(TreeNode root) {
        helper(root, 0);
        return ans;
    }
}