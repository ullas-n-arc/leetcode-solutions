class Solution {
    class DSU{
        int n;
        int rank[],parent[];
        DSU(int n){
            this.n=n;
            rank=new int[n];
            parent=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }
        int findParent(int n){
            if(n==parent[n]) return n;
            return parent[n]=findParent(parent[n]);
        }
        boolean unionByRank(int u,int v){
            int uPU=findParent(u);
            int uPV=findParent(v);
            if(uPU==uPV) return false;
            if(rank[uPU]<rank[uPV]){
                parent[uPU]=uPV;
            }else if(rank[uPU]>rank[uPV]){
                parent[uPV]=uPU;
            }else{
                parent[uPU]=uPV;
                rank[uPV]++;
            }
            return true;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        n=n+1;
        // ArrayList<Integer>[] adj=new ArrayList[n];
        // for(int i=0;i<n;i++){
        //     adj[i]=new ArrayList<>();
        // }
        DSU dsu=new DSU(n);
        // for(int i=0;i<edges.length;i++){
        //     int u=edges[i][0];
        //     int v=edges[i][1];
        //     adj[u].add(v);
        //     adj[v].add(u);
        // }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            if(!dsu.unionByRank(u,v)){
                return new int[]{u,v};
            }
        }
        return new int[]{0,0};
    }
}