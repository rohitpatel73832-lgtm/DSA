class Solution {
    public int amountOfTime(TreeNode root, int start) {
        // child -> parent
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        // Find start node
        TreeNode startNode = null;

        // BFS to create parent map
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        parent.put(root, null);

        while (!q.isEmpty()) {

            TreeNode node = q.remove();

            if (node.val == start) {
                startNode = node;
            }

            if (node.left != null) {
                parent.put(node.left, node);
                q.add(node.left);
            }

            if (node.right != null) {
                parent.put(node.right, node);
                q.add(node.right);
            }
        }

        // BFS for infection
        Set<TreeNode> visited = new HashSet<>();
        q.clear();

        q.add(startNode);
        visited.add(startNode);

        int time = -1;

        while (!q.isEmpty()) {

            int n = q.size();
            time++;

            while (n-- > 0) {

                TreeNode node = q.remove();

                // left child
                if (node.left != null &&
                    !visited.contains(node.left)) {

                    visited.add(node.left);
                    q.add(node.left);
                }

                // right child
                if (node.right != null &&
                    !visited.contains(node.right)) {

                    visited.add(node.right);
                    q.add(node.right);
                }

                // parent
                TreeNode p = parent.get(node);

                if (p != null &&
                    !visited.contains(p)) {

                    visited.add(p);
                    q.add(p);
                }
            }
        }

        return time;
    }
}