class Solution {    
    public boolean helper(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int level = 0;

        while (!q.isEmpty()) {
            int n = q.size();           
            int prev = (level % 2 == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            while (n-- > 0) {
                TreeNode node = q.remove();

                // Even level -> odd + increasing
                if (level % 2 == 0) {

                    if (node.val % 2 == 0 || node.val <= prev) {
                        return false;
                    }

                }
                // Odd level -> even + decreasing
                else {

                    if (node.val % 2 != 0 || node.val >= prev) {
                        return false;
                    }
                }

                prev = node.val;

                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }

            level++;
        }

        return true;
    }

    public boolean isEvenOddTree(TreeNode root) {
        return helper(root);
    }
}