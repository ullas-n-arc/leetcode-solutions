class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans=new ArrayList<>();
        ArrayList<Integer>[] adj=new ArrayList[graph.length];
        for(int i=0;i<graph.length;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                adj[i].add(graph[i][j]);
            }
        }
        ArrayList<Integer> path=new ArrayList<>();
        path.add(0);
        dfs(adj,0,path,ans);
        return ans;
    }
    void dfs(ArrayList<Integer>[] adj,int node,ArrayList<Integer> path,List<List<Integer>> ans){
        if(node==adj.length-1){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int next:adj[node]){
            path.add(next);
            dfs(adj,next,path,ans);
            path.remove(path.size()-1);
        }
    }
}