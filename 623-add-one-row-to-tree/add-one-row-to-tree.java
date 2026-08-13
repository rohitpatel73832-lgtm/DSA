
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
        if(root==null) return null;
        if(depth==1){
            TreeNode temp=new TreeNode(val);
            temp.left=root;
            return temp;
        }

        if(depth==2){ 
            TreeNode left=root.left;
            TreeNode right=root.right;
            TreeNode temp1=new TreeNode(val);
            TreeNode temp2= new TreeNode(val);
            root.left=temp1;
            root.right=temp2;
            temp1.left=left;
            temp2.right=right;

            return root;
        }
        root.left=addOneRow(root.left,val,depth-1);
        root.right=addOneRow(root.right,val,depth-1);
        return root;
        
    }
}