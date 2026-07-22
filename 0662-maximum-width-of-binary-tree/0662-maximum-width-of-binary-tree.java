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
    class Pair{
            TreeNode node;
            int pos;
            public Pair(TreeNode node,int pos){
                this.node=node;
                this.pos=pos;
            }
        }
    public int widthOfBinaryTree(TreeNode root) {
        Deque<Pair> q=new ArrayDeque<>();
        q.offerLast(new Pair(root,0));
        int maxSize=0;
        while(!q.isEmpty()){
            int mMin=q.peekFirst().pos;
            int first=0;
            int last=0;
            int size=q.size();
            for(int i=0;i<size;i++){
                Pair p=q.pollFirst();
                int curIndex=p.pos-mMin;
                if(i==0){
                    first=curIndex;
                }
                if(i==size-1){
                    last=curIndex;
                }
                if(p.node.left!=null){
                    q.offerLast(new Pair(p.node.left,2*curIndex+1));
                }
                if(p.node.right!=null){
                    q.offerLast(new Pair(p.node.right,2*curIndex+2));
                }
            }
            maxSize=Math.max(maxSize,last-first+1);
        }
        return maxSize;
        
    }
}