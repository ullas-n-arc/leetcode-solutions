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
                bfs(adj,i,visited);
            }
        }
        return components;
    }
    void bfs(ArrayList<Integer>[] adj,int node,boolean[] visited){
        Deque<Integer> q=new ArrayDeque<>();
        q.offerLast(node);
        visited[node]=true;
        while(!q.isEmpty()){
            int n=q.pollFirst();
            for(int x:adj[n]){
                if(!visited[x]){
                    q.offerLast(x);
                    visited[x]=true;
                }
            }
        }
    }
}