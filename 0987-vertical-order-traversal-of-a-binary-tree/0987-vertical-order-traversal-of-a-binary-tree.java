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
    static class Tuple{
        TreeNode node;
        int x;//vertical distance
        int y;//level
        Tuple(TreeNode node,int x,int y){
            this.node=node;
            this.x=x;
            this.y=y;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> nodesmap=new TreeMap<>();
        Deque<Tuple> q=new ArrayDeque<>();
        q.offerLast(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple tuple=q.pollFirst();
            TreeNode node=tuple.node;
            int x=tuple.x;
            int y=tuple.y;
            nodesmap.putIfAbsent(x,new TreeMap<>());
            nodesmap.get(x).putIfAbsent(y,new PriorityQueue<>());
            nodesmap.get(x).get(y).offer(node.val);
            if(node.left!=null){
                q.offerLast(new Tuple(node.left,x-1,y+1));
            }
            if(node.right!=null){
                q.offerLast(new Tuple(node.right,x+1,y+1));
            }
        }
        for(TreeMap<Integer,PriorityQueue<Integer>> yMap:nodesmap.values()){
            List<Integer> column=new ArrayList<>();
            for(PriorityQueue<Integer> nodes:yMap.values()){
                while(!nodes.isEmpty()){
                    column.add(nodes.poll());
                }
            }
            ans.add(column);
        }
        return ans;
    }
}