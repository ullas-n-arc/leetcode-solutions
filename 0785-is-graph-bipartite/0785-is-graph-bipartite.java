class Solution {
    //odd length cycle no bipartite
    //even length cycle bipartite
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        ArrayList<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                adj[i].add(graph[i][j]);
            }
        }
        int[] color=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(!dfs(adj,i,0,color)){
                    return false;
                }
            }
        }
        return true;
    }
    boolean dfs(ArrayList<Integer>[] adj,int node,int curColor,int[] color){
        color[node]=curColor;
        for(int n:adj[node]){
            if(color[n]==-1){
                if(!dfs(adj,n,(curColor+1)%2,color)){
                    return false;
                }
            }else if(color[n]==color[node]){
                return false;
            }
        }
        return true;
    }
}