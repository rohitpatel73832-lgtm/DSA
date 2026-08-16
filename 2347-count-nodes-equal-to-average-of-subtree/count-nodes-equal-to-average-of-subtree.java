// class Solution {
//     int count;
//     public int helper(TreeNode root,int count){
//         if(root==null) return 0;
//         count++;
//         int left=helper(root.left,count);
//         int right=helper(root.right,count);
//         return  root.val+ left+right;
//     }
//     public int averageOfSubtree(TreeNode root) {
//         if(root==null) return 0;
//         count=0;
//         int ans=0;
//         int sum=helper(root,count);
//         if(sum/count==root.val) ans++;//yaha pr error aa raha hai
//         helper(root.left,count);
//         helper(root.right,count);
//         return ans;
//     }
// }

class Solution {

    public int getSum(TreeNode root) {
        if (root == null) return 0;

        int left = getSum(root.left);
        int right = getSum(root.right);

        return root.val + left + right;
    }

    public int getCount(TreeNode root) {
        if (root == null) return 0;

        int left = getCount(root.left);
        int right = getCount(root.right);

        return 1 + left + right;
    }

    public int averageOfSubtree(TreeNode root) {
        if (root == null) return 0;

        int ans = 0;

        int sum = getSum(root);
        int count = getCount(root);

        if (sum / count == root.val) {
            ans++;
        }

        ans += averageOfSubtree(root.left);
        ans += averageOfSubtree(root.right);

        return ans;
    }
}