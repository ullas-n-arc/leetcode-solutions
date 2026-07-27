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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n=preorder.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(postorder[i],i);
        }
        TreeNode root=build(preorder,0,n-1,postorder,0,n-1,map);
        return root;
    }
    TreeNode build(int[] preorder,int preStart,int preEnd,int[] postorder,int pStart,int pEnd,HashMap<Integer,Integer> map){
        if(pStart>pEnd||preStart>preEnd){
            return null;
        }
        TreeNode root=new TreeNode(preorder[preStart]);
        if(preStart==preEnd) return root;
        int index=map.get(preorder[preStart+1]);
        int numsLeft=index-pStart+1;
        root.left=build(preorder,preStart+1,preStart+numsLeft,postorder,pStart,index,map);
        root.right=build(preorder,preStart+numsLeft+1,preEnd,postorder,index+1,pEnd-1,map);
        return root; 
    }
}