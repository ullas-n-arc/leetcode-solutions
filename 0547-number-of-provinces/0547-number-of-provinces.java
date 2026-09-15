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
    public int findCircleNum(int[][] isConnected) {
        DSU dsu=new DSU(isConnected.length);
        int components=isConnected.length;
        for(int i=0;i<isConnected.length;i++){
            for(int j=i+1;j<isConnected[0].length;j++){
                if(isConnected[i][j]==1){
                    int u=i;
                    int v=j;
                    int uPU=dsu.findRepresentative(u);
                    int uPV=dsu.findRepresentative(v);
                    if(uPU!=uPV){
                        components--;
                        dsu.unionByRank(u,v);
                    }
                }
            }
        }
        return components;
    }
}