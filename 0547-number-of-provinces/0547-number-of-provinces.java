class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        ArrayList<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isConnected[i][j]==1){
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }
        int components=0;
        boolean visited[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                components++;
                dfs(adj,i,visited);
            }
        }
        return components;
    }
    void dfs(ArrayList<Integer>[] adj,int node,boolean[] visited){
        visited[node]=true;
        for(int x:adj[node]){
            if(!visited[x]){
                visited[x]=true;
                dfs(adj,x,visited);
            }
        }
    }
}