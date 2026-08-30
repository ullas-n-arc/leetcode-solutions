class Solution {
    class Pair{
        int step;
        int source;
        int cost;
        Pair(int stop,int source,int cost){
            this.step=stop;
            this.source=source;
            this.cost=cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<int[]>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<flights.length;i++){
            int source=flights[i][0];
            int desti=flights[i][1];
            int cost=flights[i][2];
            adj[source].add(new int[]{desti,cost});
        }
        //deciding based on distance will give wrong answer we should decide based on stops
        //less price + not able to go to dest is bad thats why
        Deque<Pair> q=new ArrayDeque<>();
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        q.offer(new Pair(0,src,0));
        while(!q.isEmpty()){
            Pair p=q.pollFirst();
            int node=p.source;
            int step=p.step;
            int cost=p.cost;
            if(step>k) continue;
            for(int[] arr:adj[node]){
                int adjNode=arr[0];
                int newCost=arr[1];
                if(cost+newCost<dist[adjNode]&&step<=k){
                    dist[adjNode]=newCost+cost;
                    q.offerLast(new Pair(step+1,adjNode,dist[adjNode]));
                }
            }
        }
        if(dist[dst]==Integer.MAX_VALUE){
            return -1;
        }
        return dist[dst];
    }
}