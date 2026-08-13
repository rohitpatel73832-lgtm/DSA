
class Solution {
    public void flatten(TreeNode root) {
        if(root==null) return;
        TreeNode l=root.left;
        TreeNode r= root.right;
        root.left=null;
        flatten(l);
        flatten(r);
        root.right=l;
        TreeNode temp=root;
        while(temp!=null && temp.right!=null){
            temp=temp.right;
        }
        if(temp!=null) temp.right=r;
        else root.right=r;
        return;
    }
}