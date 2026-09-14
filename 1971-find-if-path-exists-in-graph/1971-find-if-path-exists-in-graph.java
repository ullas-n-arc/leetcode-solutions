class Solution {
    class DSU{
        int n;
        int[] rank,parent;
        public DSU(int n){
            rank=new int[n];
            parent=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }
        int findUltimateParent(int n){
            if(n==parent[n]){
                return n;
            }
            return parent[n]=findUltimateParent(parent[n]);
        } 
        void unionByRank(int u,int v){
            int ultimateParentU=findUltimateParent(u);
            int ultimateParentV=findUltimateParent(v);
            if(ultimateParentV==ultimateParentU) return;
            if(rank[ultimateParentU]<rank[ultimateParentV]){
                parent[ultimateParentU]=ultimateParentV;
            }else if(rank[ultimateParentV]<rank[ultimateParentU]){
                parent[ultimateParentV]=ultimateParentU;
            }else{
                parent[ultimateParentV]=ultimateParentU;;
                rank[ultimateParentU]++;
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        DSU dsu=new DSU(n);
        for(int i=0;i<edges.length;i++){
            dsu.unionByRank(edges[i][0],edges[i][1]);
        }
        if(dsu.findUltimateParent(source)==dsu.findUltimateParent(destination)){
            return true;
        }
        return false;
    }
}