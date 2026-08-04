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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val==key){
            return helper(root);
        }
        TreeNode cur=root;
        while(cur!=null){
            if(key>cur.val){
                if(cur.right!=null){
                    if(cur.right.val==key){
                        cur.right=helper(cur.right);
                        break;
                    }
                }
                 cur=cur.right;
            }else{
                if(cur.left!=null){
                    if(cur.left.val==key){
                         cur.left=helper(cur.left);
                         break;
                    }
                }
                cur=cur.left;
            }
        }
        return root;
    }
    TreeNode helper(TreeNode root){
        TreeNode cur=root.left;
        if(cur==null){
            return root.right;
        }
        //go to extreme right
        while(cur.right!=null){
            cur=cur.right;
        }
        cur.right=root.right;
        return root.left;

    }
}