/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return new String();
        Deque<TreeNode> q=new ArrayDeque<>();
        StringBuilder sb=new StringBuilder();
        q.offerLast(root);
        sb.append(root.val);
        while(!q.isEmpty()){
            TreeNode node=q.pollFirst();
            if(node.left!=null){
                q.offerLast(node.left);
                sb.append(","+node.left.val);
            }else{
                sb.append(","+"#");
            }
            if(node.right!=null){
                q.offerLast(node.right);
                sb.append(","+node.right.val);
            }else{
                sb.append(","+"#");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null||data.isBlank()){
            return null;
        }
        Deque<TreeNode> q=new ArrayDeque<>();
        String[] values=data.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(values[0]));
        q.offerLast(root);
        for(int i=1;i<values.length;i++){
            TreeNode parent=q.pollFirst();
            if(!values[i].equals("#")){
                parent.left=new TreeNode(Integer.parseInt(values[i]));
                q.offerLast(parent.left);
            }
            if(!values[++i].equals("#")){
                parent.right=new TreeNode(Integer.parseInt(values[i]));
                q.offerLast(parent.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));