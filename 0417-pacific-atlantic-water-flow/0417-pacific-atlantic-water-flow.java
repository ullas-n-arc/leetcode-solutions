class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        List<List<Integer>> ans=new ArrayList<>();
        boolean visited1[][]=new boolean[n][m];//visited1 is to track pacific
        boolean visited2[][]=new boolean[n][m];//visited2 is to track atlantic
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0||j==0){
                    dfs(heights,visited1,i,j,n,m);
                }
                if(i==n-1||j==m-1){
                   dfs(heights,visited2,i,j,n,m);
                }
            }
        }
        for(int i=0;i<n;i++){
            List<Integer> subList=new ArrayList<>();
            for(int j=0;j<m;j++){
                if(visited1[i][j]&&visited2[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
    void dfs(int[][] heights,boolean[][] visited,int i,int j,int R,int C){
        visited[i][j]=true;
        int dirs[][]={{-1,0},{1,0},{0,1},{0,-1}};
        for(int dir[]:dirs){
            int newRow=i+dir[0];
            int newCol=j+dir[1];
            if(isValid(newRow,newCol,R,C)&&!visited[newRow][newCol]&&heights[newRow][newCol]>=heights[i][j]){
                dfs(heights,visited,newRow,newCol,R,C);
            }
        }
    }
    boolean isValid(int r,int c,int R,int C){
        if(r<0||c<0||r>=R||c>=C) return false;
        return true;
    }
}