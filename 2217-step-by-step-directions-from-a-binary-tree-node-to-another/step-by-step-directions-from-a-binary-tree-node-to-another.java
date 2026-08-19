// class Solution {

//     public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {

//         if (root == null || root.val == p || root.val == q) {
//             return root;
//         }

//         TreeNode left = lowestCommonAncestor(root.left, p, q);
//         TreeNode right = lowestCommonAncestor(root.right, p, q);

//         if (left != null && right != null) {
//             return root;
//         }

//         return left != null ? left : right;
//     }

//     public String helper(TreeNode root, int target, String l) {

//     if (root == null) {
//         return null;
//     }

//     if (root.val == target) {
//         return l;
//     }

//     String left = helper(root.left, target, l + "L");

//     if (left != null) {
//         return left;
//     }

//     return helper(root.right, target, l + "R");
// }

//     public String getDirections(TreeNode root, int startValue, int destValue) {

//         TreeNode node = lowestCommonAncestor(root, startValue, destValue);

//         String l = helper(node, startValue, "");
//         String r = helper(node, destValue, "");

//         StringBuilder ans = new StringBuilder();

//         for (int i = 0; i < l.length(); i++) {
//             ans.append("U");
//         }

//         for (int i = 0; i < r.length(); i++) {
//             ans.append(r.charAt(i));
//         }

//         return ans.toString();
//     }
// }

class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode startNode = null;

        while (!q.isEmpty()) {
            TreeNode curNode = q.poll();

            if (curNode.val == startValue) {
                startNode = curNode;
                break;
            }

            if (curNode.left != null) {
                q.offer(curNode.left);
            }
            if (curNode.right != null) {
                q.offer(curNode.right);
            }
        }

        Map<Integer, TreeNode> nodesParents = new HashMap<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode curNode = q.poll();

            if (curNode.left != null) {
                nodesParents.put(curNode.left.val, curNode);
                q.offer(curNode.left);
            }
            if (curNode.right != null) {
                nodesParents.put(curNode.right.val, curNode);
                q.offer(curNode.right);
            }
        }

        Set<TreeNode> visited = new HashSet<>();
        q.offer(startNode);
        Map<TreeNode, Pair<TreeNode, String>> trackedPath = new HashMap<>();
        TreeNode destinationNode = null;

        while (!q.isEmpty()) {
            TreeNode curNode = q.poll();
            visited.add(curNode);

            if (curNode.val == destValue) {
                destinationNode = curNode;
                break;
            }

            if (nodesParents.containsKey(curNode.val) && !visited.contains(nodesParents.get(curNode.val))) {
                TreeNode parent = nodesParents.get(curNode.val);
                q.offer(parent);
                trackedPath.put(parent, new Pair<>(curNode, "U"));
            }

            if (curNode.left != null && !visited.contains(curNode.left)) {
                q.offer(curNode.left);
                trackedPath.put(curNode.left, new Pair<>(curNode, "L"));
            }

            if (curNode.right != null && !visited.contains(curNode.right)) {
                q.offer(curNode.right);
                trackedPath.put(curNode.right, new Pair<>(curNode, "R"));
            }
        }

        List<String> resultPath = new ArrayList<>();
        TreeNode curNode = destinationNode;

        while (curNode != startNode) {
            Pair<TreeNode, String> sourceAndDirection = trackedPath.get(curNode);
            resultPath.add(sourceAndDirection.getValue());
            curNode = sourceAndDirection.getKey();
        }

        Collections.reverse(resultPath);
        return String.join("", resultPath);
    }
}

