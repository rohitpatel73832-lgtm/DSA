class Solution {
    int count=0;
    public void helper(TreeNode root,int[] arr){
        if(root==null) return ;
        arr[root.val]++;
        if(root.left==null && root.right==null){
            int oddNum=0;
            for(int i=1; i<=9; i++){
                if(arr[i]%2 !=0){
                    oddNum++;
                }
            }
            if(oddNum<=1){
                count++;
            }

        }
        helper(root.left,arr);
        helper(root.right,arr);

        arr[root.val]--;
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] arr= new int[10];

        helper(root,arr);
        return count;
    }
}