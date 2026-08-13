class Solution {
    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = helper(root.left);
        int rightSum = helper(root.right);

        return root.val + leftSum + rightSum;
    }   

    long ans = 0;

    public int find(TreeNode root, int totalSum) {

        if (root == null) {
            return 0;
        }

        int sum = root.val + find(root.left, totalSum)+ find(root.right, totalSum);
        long remain = totalSum - sum;

        ans = Math.max(ans, (long) sum * remain);

        return sum;
    }

    public int maxProduct(TreeNode root) {
        int totalSum = helper(root);
        find(root, totalSum);

        return (int)(ans % 1000000007);
    }
}