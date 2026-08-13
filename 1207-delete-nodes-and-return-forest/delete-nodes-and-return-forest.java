
class Solution {
    public TreeNode helper(TreeNode root,HashSet<Integer> st,List<TreeNode> ans){
        if(root == null) {
            return null;
        }
        root.left=helper(root.left,st,ans);
        root.right=helper(root.right,st,ans);
        if(st.contains(root.val)){
            if(root.left!=null){
                ans.add(root.left);
            }
            if(root.right!=null){
                ans.add(root.right);
            }
            return null;
        }else{
            return root;
        }
    }
    public List<TreeNode> delNodes(TreeNode root, int[] del) {
        HashSet<Integer> st= new HashSet<>();
        List<TreeNode> ans=new ArrayList<>();
        // int n=del.length;
        for(int num:del){
            st.add(num);
        }
        
        root = helper(root, st, ans);

        if (root != null) {
        ans.add(root);
        }

       return ans;
    }
}