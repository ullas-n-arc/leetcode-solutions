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
    int count=0;
    public int kthSmallest(TreeNode root, int k) { 
        return inorder(root,k);
    }
    int inorder(TreeNode root,int k){
        //morris inorder
        TreeNode cur=root;
        while(cur!=null){
            if(cur.left==null){
                count++;
                if(k==count){
                    return cur.val;
                }
                cur=cur.right;
            }else{
                TreeNode predecessor=cur.left;
                while(predecessor.right!=null&&predecessor.right!=cur){
                    predecessor=predecessor.right;
                }
                if(predecessor.right==null){
                    predecessor.right=cur;
                    cur=cur.left;
                }
                if(predecessor.right==cur){
                    predecessor.right=null;
                    //visited 2 times 
                    count++;
                    if(k==count){
                        return cur.val;
                    }
                    cur=cur.right;
                }
            }
        }
        return -1;
    }
}