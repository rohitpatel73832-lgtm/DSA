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
    public void inorder(TreeNode root,ArrayList<Integer> arr){
        if(root==null) return;
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }
        public void fixTree(TreeNode root, ArrayList<Integer> arr, int[] index) {
        if(root == null) return;

        fixTree(root.left, arr, index);

        root.val = arr.get(index[0]);
        index[0]++;

        fixTree(root.right, arr, index);
    }

    public void recoverTree(TreeNode root) {

        ArrayList<Integer> arr = new ArrayList<>();

        
        inorder(root, arr);

        
        Collections.sort(arr);

        
        int[] index = {0};
        

        fixTree(root, arr, index);
    }
}
