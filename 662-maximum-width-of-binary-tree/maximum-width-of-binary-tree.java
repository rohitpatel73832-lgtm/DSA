class Solution {
    class Pair{
        TreeNode node;
        int index;

        Pair(TreeNode node, int index){
            this.node=node;
            this.index=index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        //your code goes here
        if(root==null) return 0;
       Queue<Pair> q= new LinkedList<>();
       int width=0;
       q.add(new Pair(root, 0));

       while(q.size()>0){
        int n= q.size();
         Pair j= q.peek();
         int minIdx=j.index;
         int maxIdx=0;
        while(n-->0){
            Pair p= q.remove();
            TreeNode node=p.node;
            maxIdx=p.index;
            if(node.left!=null)  q.add(new Pair(node.left, 2 * maxIdx + 1));
            if(node.right!=null) q.add(new Pair(node.right, 2 * maxIdx + 2));
        }
        width=Math.max(width,maxIdx-minIdx+1);
       }
       return width;
    }
}