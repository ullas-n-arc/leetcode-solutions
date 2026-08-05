class Solution {
    public int findCircleNum(int[][] isConnected) {
        int v=isConnected.length;
        ArrayList<Integer>[] adj=new ArrayList[v];
        for(int i=0;i<v;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<v;i++){
            for(int j=i+1;j<v;j++){
                if(isConnected[i][j]==1){
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }
        int count=0;
        boolean visited[]=new boolean[v];
        for(int i=0;i<v;i++){
            if(!visited[i]){
                count++;
                bfs(i,adj,visited);
            }
        }
        return count;
    }
    void bfs(int node,ArrayList<Integer>[] adj,boolean[] visited){
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