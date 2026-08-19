class Solution {

    HashMap<TreeNode, List<TreeNode>> graph = new HashMap<>();
    List<TreeNode> leaves = new ArrayList<>();

    public void makeGraph(TreeNode root, TreeNode parent) {

        if (root == null) return;

        graph.putIfAbsent(root, new ArrayList<>());

        if (root.left == null && root.right == null) {
            leaves.add(root);
        }

        if (parent != null) {
            graph.get(root).add(parent);
            graph.get(parent).add(root);
        }

        makeGraph(root.left, root);
        makeGraph(root.right, root);
    }

    public int bfs(TreeNode start, int d, int index) {

        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();

        q.add(start);
        visited.add(start);

        int distance = 0;
        int count = 0;

        while (!q.isEmpty() && distance <= d) {

            int n = q.size();

            while (n-- > 0) {

                TreeNode node = q.remove();

                // If this is another leaf
                if (node != start &&
                    node.left == null &&
                    node.right == null) {

                    int leafIndex = leaves.indexOf(node);

                    if (leafIndex > index) {
                        count++;
                    }
                }

                for (TreeNode next : graph.get(node)) {

                    if (!visited.contains(next)) {

                        visited.add(next);
                        q.add(next);
                    }
                }
            }

            distance++;
        }

        return count;
    }

    public int countPairs(TreeNode root, int d) {

        makeGraph(root, null);

        int ans = 0;

        for (int i = 0; i < leaves.size(); i++) {

            ans += bfs(leaves.get(i), d, i);
        }

        return ans;
    }
}