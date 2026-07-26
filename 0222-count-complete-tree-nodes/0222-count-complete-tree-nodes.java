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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int lHeight=height(root,true);
        int rHeight=height(root,false);
        if(lHeight==rHeight){
            return (1<<lHeight)-1;
        }
        return 1+countNodes(root.left)+countNodes(root.right);   
    }
    int height(TreeNode root,boolean isLeft){
        if(root==null) return 0;
        if(isLeft){
            return 1+height(root.left,isLeft);
        }else{
            return 1+height(root.right,isLeft);
        }
    }
}