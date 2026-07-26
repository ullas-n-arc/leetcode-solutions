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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=inorder.length;
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
        TreeNode root=build(inorder,0,n-1,postorder,0,n-1,map);
        return root;
    }
    TreeNode build(int[] inorder,int inStart,int inEnd,int[] postorder,int pStart,int pEnd,HashMap<Integer,Integer> map){
        if(inStart>inEnd||pStart>pEnd) return null;
        TreeNode root=new TreeNode(postorder[pEnd]);
        int inRoot=map.get(root.val);
        int numsRight=inEnd-inRoot;
        root.left=build(inorder,inStart,inRoot-1,postorder,pStart,pEnd-numsRight-1,map);
        root.right=build(inorder,inRoot+1,inEnd,postorder,pEnd-numsRight,pEnd-1,map);
        return root;
    }
}