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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans =new ArrayList<>();
        if(root==null){
            return ans;
        }
        Deque<TreeNode> q=new ArrayDeque<>();
        int dir=0;
        q.offerLast(root);
        while(!q.isEmpty()){
            Deque<Integer> subList=new ArrayDeque<>();
            int level=q.size();
            for(int i=0;i<level;i++){
                TreeNode node=q.pollFirst();
                if(dir==0){
                    subList.offerLast(node.val);
                }else{
                    subList.offerFirst(node.val);
                }
                if(node.left!=null)q.offerLast(node.left);
                if(node.right!=null)q.offerLast(node.right);
            }
            dir=(dir+1)%2;
            ans.add(new ArrayList<>(subList));
        }
        return ans;
        
    }
}