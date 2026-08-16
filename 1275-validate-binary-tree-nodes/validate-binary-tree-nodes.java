class Solution {

    public void helper(int n, int[] leftChild, int[] rightChild, int[] indegree) {

        for (int i = 0; i < n; i++) {

            if (leftChild[i] != -1) {
                indegree[leftChild[i]]++;
            }

            if (rightChild[i] != -1) {
                indegree[rightChild[i]]++;
            }
        }
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        int[] indegree = new int[n];

        helper(n, leftChild, rightChild, indegree);

        // 1. No node can have more than one parent
        for (int i = 0; i < n; i++) {
            if (indegree[i] > 1) {
                return false;
            }
        }

        // 2. Find exactly one root
        int root = -1;

        for (int i = 0; i < n; i++) {

            if (indegree[i] == 0) {

                if (root != -1) {
                    return false;
                }

                root = i;
            }
        }

        if (root == -1) {
            return false;
        }

        // 3. Check that every node is connected to root
        boolean[] visited = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        q.offer(root);

        int count = 0;

        while (!q.isEmpty()) {

            int node = q.poll();

            if (visited[node]) {
                return false;
            }

            visited[node] = true;
            count++;

            if (leftChild[node] != -1) {
                q.offer(leftChild[node]);
            }

            if (rightChild[node] != -1) {
                q.offer(rightChild[node]);
            }
        }

        return count == n;
    }
}