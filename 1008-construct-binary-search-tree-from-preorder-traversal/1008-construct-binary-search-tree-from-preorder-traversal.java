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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root=new TreeNode(preorder[0]);
        for(int i=1;i<preorder.length;i++){
            TreeNode cur=root;
            TreeNode prev=null;
            while(cur!=null){
                prev=cur;
                if(preorder[i]<cur.val){
                    cur=cur.left;
                }else{
                    cur=cur.right;
                }
            }
            if(prev!=null)
            if(prev.val<preorder[i]){
                prev.right=new TreeNode(preorder[i]);
            }else{
                prev.left=new TreeNode(preorder[i]);
            }
        }
        return root;
    }
}