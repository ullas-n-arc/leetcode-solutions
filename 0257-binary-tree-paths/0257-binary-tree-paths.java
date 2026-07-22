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
        StringBuilder sb=new StringBuilder();
        myFun(root,sb);
        return ans;
    }
    public void  myFun(TreeNode root,StringBuilder sb){
        // if(root==null) {
        //     ans.add(sb.toString());
        //     return;
        // }
        // sb.append(root.val);
        // //int checkPoint=sb.length();
        // myFun(root.left,sb);
        // //sb.setLength(checkPoint);


        // //checkPoint=sb.length();
        // myFun(root.right,sb);
        // //sb.setLength(checkPoint);
        

        // valid path only if both child are null
        //sb.append(root.val);
        if(root==null) return;
        if(root.left==null&&root.right==null){
            sb.append(root.val);
            ans.add(sb.toString());
            return;
        }
        sb.append(root.val+"->");// not last
            int checkPoint=sb.length();
            myFun(root.left,sb);
            sb.setLength(checkPoint);
            myFun(root.right,sb);
            sb.setLength(checkPoint);

    }
}