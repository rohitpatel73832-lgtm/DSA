// class Solution {
//     public boolean search(TreeNode root, TreeNode p) {
//         if (root == null) return false;
//         if (root == p) return true;

//         return search(root.left, p) || search(root.right, p);
//     }

//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if (root == null) return null;
//         if (root == p || root == q) {
//             return root;
//         }

//         boolean pLeft = search(root.left, p);
//         boolean qLeft = search(root.left, q);

//         // Both are in left subtree
//         if (pLeft && qLeft) {
//             return lowestCommonAncestor(root.left, p, q);
//         }

//         // Both are in right subtree
//         boolean pRight = search(root.right, p);
//         boolean qRight = search(root.right, q);

//         if (pRight && qRight) {
//             return lowestCommonAncestor(root.right, p, q);
//         }

//         // One is on left and one is on right
//         return root;
//     }
// }

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// class Solution {
//     public boolean isContains(TreeNode root,TreeNode node){
//         if(root == null) return false;
//         if(root==node) return true;
//         return isContains(root.left,node) || isContains(root.right,node);
//     }
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if(p==root|| q==root) return root;
//         if(p==q) return p;
//         boolean leftp= isContains(root.left,p);
//         boolean rightq=isContains(root.right,q);
//         if((leftp && rightq) || (!leftp && !rightq)) return root;
//         if(leftp && !rightq) return lowestCommonAncestor(root.left,p,q);
//         if(!leftp && rightq) return lowestCommonAncestor(root.right,p,q);
//         return null;
//     }
// }

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}