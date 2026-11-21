class Solution {
    int result[];
    int lastSeen[];
    ArrayList<Integer>[] adj;
    void dfs(int node,String s,int[] parent){
        int c=s.charAt(node)-'a';
        int nearestAncestor=lastSeen[c];
        lastSeen[c]=node;
        for(int child:adj[node]){
            dfs(child,s,parent);
        }
        lastSeen[c]=nearestAncestor;
        int newParent=parent[node];
        if(node!=0){
            if(nearestAncestor!=-1){
                newParent=nearestAncestor;
                parent[node]=newParent;
            }
            result[newParent]+=result[node];
        }
    }
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n=parent.length;
        result=new int[n];
        lastSeen=new int[26];
        Arrays.fill(result,1);
        Arrays.fill(lastSeen,-1);
        adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=1;i<n;i++){
            int u=parent[i];
            int v=i;
            adj[u].add(v);
        }
        dfs(0,s,parent);
        return result;
    }
}