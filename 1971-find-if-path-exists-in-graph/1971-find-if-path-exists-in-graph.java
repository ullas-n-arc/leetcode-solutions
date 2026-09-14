class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj[u].add(v);
            adj[v].add(u);
        }
        boolean[] visited=new boolean[n];
        dfs(adj,visited,source);
        return visited[destination];
    }
    void dfs(ArrayList<Integer>[] adj,boolean[] visited,int src){
        visited[src]=true;
        for(int neighbor:adj[src]){
            if(!visited[neighbor])
                dfs(adj,visited,neighbor);
        }
    }
}