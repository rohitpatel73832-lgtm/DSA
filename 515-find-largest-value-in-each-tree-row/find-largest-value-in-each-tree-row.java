class Solution {
    public List<Integer> largestValues(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            int n = q.size();
            int mx = Integer.MIN_VALUE;

            while (n-- > 0) {

                TreeNode node = q.remove();

                // Check current node
                mx = Math.max(mx, node.val);

                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }

            ans.add(mx);
        }

        return ans;
    }
}