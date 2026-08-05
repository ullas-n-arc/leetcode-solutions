class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<n;i++){
            result.add(i);
        }
        ArrayList<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<invocations.length;i++){
            int u=invocations[i][0];
            int v=invocations[i][1];
            adj[u].add(v);
        }
        //start bfs from infected node k
        Deque<Integer> q=new ArrayDeque<>();
        boolean[] visited=new boolean[n];
        boolean[] suspicious=new boolean[n];
        q.offerLast(k);
        suspicious[k]=true;
        while(!q.isEmpty()){
            int node=q.pollFirst();
            for(int x:adj[node]){
                if(!suspicious[x]){
                    q.offerLast(x);
                    suspicious[x]=true;
                }
            }
        }
        // non suspicious makes call to suspicious
        for(int i=0;i<n;i++){
            if(!suspicious[i]){
                for(int node:adj[i]){
                    if(suspicious[node])return result;
                }
            }
        }
        result=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!suspicious[i]){
                result.add(i);
            }
        }
        return result;
    }
}