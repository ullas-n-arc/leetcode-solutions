class Solution {
    class Pair{
        int node;
        int time;
        Pair(int _node,int _time){
            node=_node;
            time=_time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Pair>[] adj=new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<times.length;i++){
            int u=times[i][0];
            int v=times[i][1];
            int time=times[i][2];
            adj[u].add(new Pair(v,time));
        }
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Integer.compare(a.time,b.time));
        pq.offer(new Pair(k,0));
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int curNode=p.node;
            int curTime=p.time;
            if(curTime>dist[curNode]) continue;
            for(Pair pair:adj[curNode]){
                int newNode=pair.node;
                int newTime=curTime+pair.time;
                if(newTime<dist[newNode]){
                    dist[newNode]=newTime;
                    pq.offer(new Pair(newNode,newTime));
                }
            }
        }
        int time=0;
        for(int i=1;i<n+1;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            time=Math.max(time,dist[i]);
        }
        return time;
    }
}