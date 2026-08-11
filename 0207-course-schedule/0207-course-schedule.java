class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];
            adj[u].add(v);
        }
        boolean[] visited=new boolean[numCourses];
        boolean[] pathVisited=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(dfs(adj,i,visited,pathVisited)){
                    return false;
                }
            }
        }
        return true;
    }
    boolean dfs(ArrayList<Integer>[] adj,int node,boolean[] visited,boolean[] pathVisited){
        visited[node]=true;
        pathVisited[node]=true;
        for(int n:adj[node]){
            if(!visited[n]){
                if(dfs(adj,n,visited,pathVisited)){
                    return true;
                }
            }else if(pathVisited[n]==true){
                return true;
            }
        }
        pathVisited[node]=false;
        return false;
    }
}