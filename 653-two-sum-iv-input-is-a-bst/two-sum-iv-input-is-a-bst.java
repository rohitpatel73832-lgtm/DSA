/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void inorder(TreeNode root, ArrayList<Integer> arr) {
        if(root == null) return;

        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
    }

    public boolean findTarget(TreeNode root, int k) {

        ArrayList<Integer> arr = new ArrayList<>();

        inorder(root, arr);

        int left = 0;
        int right = arr.size() - 1;

        while(left < right) {

            int sum = arr.get(left) + arr.get(right);

            if(sum == k) {
                return true;
            }
            else if(sum < k) {
                left++;
            }
            else {
                right--;
            }
        }

        return false;
    }
}