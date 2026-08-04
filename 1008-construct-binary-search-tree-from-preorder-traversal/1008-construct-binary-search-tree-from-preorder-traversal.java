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
    HashMap<Integer,Integer> map=new HashMap<>();
    public TreeNode bstFromPreorder(int[] preorder) {
        int n=preorder.length;
        int[] inorder=preorder.clone();
        Arrays.sort(inorder);
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
        return build(preorder,inorder,0,0,n-1);
    }
    TreeNode build(int[] preorder,int[] inorder,int i,int inStart,int inEnd){
        if(inStart>inEnd) return null;
        int rootval=preorder[i];
        TreeNode root=new TreeNode(rootval);
        int index=map.get(rootval);
        int leftSize=index-inStart;
        root.left=build(preorder,inorder,i+1,inStart,index-1);
        root.right=build(preorder,inorder,i+leftSize+1,index+1,inEnd);
        return root;

    }
}