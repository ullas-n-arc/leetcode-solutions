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
    public int averageOfSubtree(TreeNode root) {
        return myFun(root);
    }
    int myFun(TreeNode root){
        if(root==null) return 0;
        int[] leftSum=sumCount(root.left);
        int[] rightSum=sumCount(root.right);
        int sum=root.val+leftSum[0]+rightSum[0];
        int count=1+leftSum[1]+rightSum[1];
        if(count!=0){
            if(sum/count==root.val){
                return 1+myFun(root.left)+myFun(root.right);
            }
        }
        return myFun(root.left)+myFun(root.right);
    }
    int[] sumCount(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }
        if(root.left==null&&root.right==null){
            return new int[]{root.val,1};
        }
        int right[]=sumCount(root.right);
        int left[]=sumCount(root.left);
        return new int[]{root.val+left[0]+right[0],1+left[1]+right[1]};
    }
}