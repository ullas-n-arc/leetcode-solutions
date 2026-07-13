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
    // class Tuple{
    //     TreeNode node;
    //     int x;//horizontal distance
    //     Tuple(TreeNode node,int x){
    //         this.node=node;
    //         this.x=x;
    //     }
    // }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        Deque<TreeNode> q=new ArrayDeque<>();
        q.offerLast(root);
        int curLevel=0;
        while(!q.isEmpty()){
            int level=q.size();
            for(int i=0;i<level;i++){
                TreeNode node=q.pollFirst();
                map.put(curLevel,node.val);
                if(node.left!=null){
                    q.offerLast(node.left);
                }
                if(node.right!=null){
                    q.offerLast(node.right);
                }
            }
            curLevel++;
        }
        for(int val:map.values()){
            ans.add(val);
        }
        return ans;
    }
}