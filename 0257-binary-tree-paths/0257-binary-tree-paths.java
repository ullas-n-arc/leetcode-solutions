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
    List<String> ans=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        myFun(root,new StringBuilder());
        return ans;
    }
    public void  myFun(TreeNode root,StringBuilder sb){
        if(root.left==null&&root.right==null){
            sb.append(root.val);
            ans.add(sb.toString());
        }
        sb.append(root.val+"->");
        if(root.left!=null){
            int len=sb.length();
            myFun(root.left,sb);
            sb.setLength(len);
        }
        if(root.right!=null){
            int len=sb.length();
            myFun(root.right,sb);
            sb.setLength(len);
        }
    }
}