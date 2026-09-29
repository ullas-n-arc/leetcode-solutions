class Solution {
    class DSU{
        int n;
        int[] rank;
        int[] parent;
        DSU(int n){
            this.n=n;
            rank=new int[n];
            parent=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }
        int findParent(int n){
            if(parent[n]==n){
                return n;
            }
            return parent[n]=findParent(parent[n]);
        }
        void unionByRank(int u,int v){
            int uPu=findParent(u);
            int uPv=findParent(v);
            if(uPu==uPv) return;
            if(rank[uPu]<rank[uPv]){
                parent[uPu]=uPv;
            }else if(rank[uPv]<rank[uPu]){
                parent[uPv]=uPu;
            }else{
                parent[uPu]=uPv;
                rank[uPv]++;
            }
        }
    }
    public int removeStones(int[][] stones) {
        //for row i will keep as is
        //for col i map to i+Maxrow+1
        //row 0 and col  3 are in one component
        int maxRow=0;
        int maxCol=0;
        for(int i=0;i<stones.length;i++){
            maxRow=Math.max(maxRow,stones[i][0]);
            maxCol=Math.max(maxCol,stones[i][1]);
        }
        int offset=maxRow+1;
        DSU dsu=new DSU(maxRow+maxCol+2);
        HashSet<Integer> used = new HashSet<>();
        for(int i=0;i<stones.length;i++){
            dsu.unionByRank(stones[i][0],stones[i][1]+offset);
            used.add(stones[i][0]);
            used.add(stones[i][1]+offset);
        }
        HashSet<Integer> components=new HashSet<>();
        for(int node:used){
            components.add(dsu.findParent(node));
        }
        return stones.length-components.size();
    }
}