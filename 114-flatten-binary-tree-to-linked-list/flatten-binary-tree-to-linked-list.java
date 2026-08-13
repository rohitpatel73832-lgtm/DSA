
class Solution {
    public void flatten(TreeNode root) {
        // if(root==null) return;
        // TreeNode l=root.left;
        // TreeNode r= root.right;
        // root.left=null;
        // flatten(l);
        // flatten(r);
        // root.right=l;
        // TreeNode temp=root;
        // while(temp!=null && temp.right!=null){
        //     temp=temp.right;
        // }
        // if(temp!=null) temp.right=r;
        // else root.right=r;
        // return;

        //Morris- Traversal

        TreeNode curr=root;
        while(curr!=null){
            if(curr.left!=null){
                TreeNode pred=curr.left;
                while(pred.right!=null){
                    pred=pred.right;
                }
                pred.right=curr.right;
                curr.right=curr.left;
                curr.left=null;
            }
            curr=curr.right;
        }
        
    }
}