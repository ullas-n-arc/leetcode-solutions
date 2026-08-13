class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph){
        int V=graph.length;
        List<Integer> safe=new ArrayList<>();
        boolean[] check=new boolean[V];
        ArrayList<Integer>[] adj=new ArrayList[V];
        for(int i=0;i<V;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                adj[i].add(graph[i][j]);
            }
        }
        boolean visited[]=new boolean[V];
        boolean pathVisited[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfs(adj,i,visited,pathVisited,check)){
                    check[i]=false;
                }
            }
        }
        for(int i=0;i<V;i++){
            if(check[i]){
                safe.add(i);
            }
        }
        return safe;
    }
    boolean dfs(ArrayList<Integer>[] adj,int node,boolean[] visited,boolean[] pathVisited,boolean check[]){
        visited[node]=true;
        pathVisited[node]=true;
        for(int n:adj[node]){
            if(!visited[n]){
                if(dfs(adj,n,visited,pathVisited,check)){
                    return true;
                }
            }else if(pathVisited[n]){
                return true;
            }
        }
        pathVisited[node]=false;
        check[node]=true;
        return false;
    }
}