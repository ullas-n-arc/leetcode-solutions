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
    int ans=0;
    int maxLevelSoFar=0;
    public int findBottomLeftValue(TreeNode root) {
        ans=root.val;
        myFun(root,0);
        return ans;
    }
    void myFun(TreeNode root,int level){
        if(root==null) return;
        if(level>maxLevelSoFar){
            maxLevelSoFar=level;
            ans=root.val;
        }
        myFun(root.left,level+1);
        myFun(root.right,level+1);
    }
}