class Solution {
    class DSU{
        int[] rank,parent;
        int n;
        DSU(int n){
            this.n=n;
            rank=new int[n];
            parent=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }
        int findRepresentative(int n){
            if(parent[n]==n){
                return n;
            }
            return parent[n]=findRepresentative(parent[n]);
        }
        void unionByRank(int u,int v){
            int uPU=findRepresentative(u);
            int uPV=findRepresentative(v);
            if(uPU==uPV) return;
            if(rank[uPU]<rank[uPV]){
                parent[uPU]=uPV;
            }else if(rank[uPV]<rank[uPU]){
                parent[uPV]=uPU;
            }else{
                parent[uPV]=uPU;
                rank[uPU]++;
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        DSU dsu=new DSU(n);
        int components=n;
        for(int i=0;i<connections.length;i++){
            int u=connections[i][0];
            int v=connections[i][1];
            int uPU=dsu.findRepresentative(u);
            int uPV=dsu.findRepresentative(v);
            if(uPU!=uPV){
                components--;
                dsu.unionByRank(u,v);
            }
        }
        int extraWireNeeded=components-1;
        int extraAvailable=0;
        int inDegree[]=new int[n];
        for(int i=0;i<connections.length;i++){
            inDegree[connections[i][1]]++;
        }
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]>1){
                extraAvailable+=inDegree[i]-1;
            }
        }
        if(extraAvailable>=extraWireNeeded){
            return extraWireNeeded;
        }
        return -1;
    }
}