class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean key[]=new boolean[n];
        key[0]=true;
        for(int room:rooms.get(0)){
            dfs(rooms,room,key);
        }
        for(int i=0;i<n;i++){
            if(key[i]==false) return false;
        }
        return true;
    }
    void dfs(List<List<Integer>> rooms,int room,boolean[] key){
        key[room]=true;
        for(int r:rooms.get(room)){
            if(!key[r]){
                dfs(rooms,r,key);
            }
        }
    }
}