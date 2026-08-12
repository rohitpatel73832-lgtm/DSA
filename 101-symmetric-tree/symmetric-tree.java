
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if((p==null && q!=null) || (q==null && p!=null)) return false;
        if(p.val!=q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public TreeNode invertTree(TreeNode root) {
          if(root==null) return root;
          TreeNode l=root.left;
          TreeNode r=root.right;
          root.left=invertTree(r);
          root.right=invertTree(l);
          return root;

    }
    public boolean isSymmetric(TreeNode root) {
        TreeNode leftRev=invertTree(root.right);
        return isSameTree(root.left,leftRev);
    }
}