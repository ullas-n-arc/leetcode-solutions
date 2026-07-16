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

    List<Integer> ans=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        myFun(root,0);
        return ans;
    }
    void myFun(TreeNode root,int level){
        if(root==null) return;
        if(level==ans.size()){
            ans.add(root.val);
        }
        myFun(root.right,level+1);
        myFun(root.left,level+1);
    }
}