/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // Step 1: Store parent of every node
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node.left != null) {
                parent.put(node.left, node);
                q.offer(node.left);
            }

            if (node.right != null) {
                parent.put(node.right, node);
                q.offer(node.right);
            }
        }

        // Step 2: BFS from target
        Queue<TreeNode> bfs = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();

        bfs.offer(target);
        visited.add(target);

        while (!bfs.isEmpty()) {

            if (k == 0)  
                break;

            int size = bfs.size();

            while (size-- > 0) {

                TreeNode node = bfs.poll();

                // Left child
                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    bfs.offer(node.left);
                }

                // Right child
                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    bfs.offer(node.right);
                }

                // Parent
                if (parent.containsKey(node) && !visited.contains(parent.get(node))) {
                    visited.add(parent.get(node));
                    bfs.offer(parent.get(node));
                }
            }

            k--;
        }

        // Step 3: Remaining nodes are at distance k
        List<Integer> ans = new ArrayList<>();

        while (!bfs.isEmpty()) {
            ans.add(bfs.poll().val);
        }

        return ans;
    }
}