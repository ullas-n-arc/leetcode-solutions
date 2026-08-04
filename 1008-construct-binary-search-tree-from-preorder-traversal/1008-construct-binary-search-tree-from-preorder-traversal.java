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
    int preStart=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder,Integer.MAX_VALUE);
    }
    TreeNode bstFromPreorder(int[] preorder,int max){
        if(preStart>=preorder.length||preorder[preStart]>max) return null;
        TreeNode root=new TreeNode(preorder[preStart++]);
        root.left=bstFromPreorder(preorder,root.val);
        root.right=bstFromPreorder(preorder,max);
        return root;
    }
}