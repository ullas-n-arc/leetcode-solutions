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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        Deque<TreeNode> q=new ArrayDeque<>();
        if(root==null){
            return ans;
        }
        q.offerLast(root);
        while(!q.isEmpty()){
            int level=q.size();
            ArrayList<Integer> subList=new ArrayList<>();
            for(int i=0;i<level;i++){
                TreeNode node=q.pollFirst();
                subList.add(node.val);
                if(node.left!=null)q.offerLast(node.left);
                if(node.right!=null)q.offerLast(node.right);
            }
            ans.add(subList);
        }
        return ans;
    }
}