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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<>();
        List<Integer> sum=new ArrayList<>();

        q.add(root);
        //finding level sum and storing to the list as considering index as levels of trees
        while(q.size()>0){
            int n=q.size();
            int count=0;
            while(n-->0){
                TreeNode node= q.remove();
                count+=node.val;
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            sum.add(count);
        }

        //updating each node value with cousin sum
        q.add(root);
        root.val=0;
        int i=1;
        while(q.size()>0){
            int n=q.size();
            while(n-->0){
                TreeNode temp=q.remove();
                int siblingSum=0;
                if(temp.left!=null){
                    siblingSum+=temp.left.val;
                }else{
                    siblingSum+=0;
                }

                if(temp.right!=null){
                    siblingSum+=temp.right.val;
                }else{
                    siblingSum+=0;
                }

                if(temp.left!=null){
                    temp.left.val=sum.get(i)-siblingSum;
                    q.add(temp.left);
                }

                if(temp.right!=null){
                    temp.right.val=sum.get(i)-siblingSum;
                    q.add(temp.right);
                }
            }
            i++;
        }
        return root;
    }
}