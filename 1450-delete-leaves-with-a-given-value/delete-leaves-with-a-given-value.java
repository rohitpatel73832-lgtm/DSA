class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root==null) return null;
        
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        // Node may become a leaf after deleting children
        if(root.left==null && root.right==null){//leaf node
            if(root.val==target){
                return null;
            }
        }
        return root;
    }
}