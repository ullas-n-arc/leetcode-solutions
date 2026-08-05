class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'&&!visited[i][j]){
                    count++;
                    bfs(i,j,grid,visited);
                }
            }
        }
        return count;
    }
    void bfs(int row,int col,char[][] grid,boolean[][] visited){
        Deque<int[]> q=new ArrayDeque<>();
        int dirs[][]={{-1,0},{1,0},{0,1},{0,-1}};
        q.offerLast(new int[]{row,col});
        visited[row][col]=true;
        while(!q.isEmpty()){
            int[] cell=q.pollFirst();
            int r=cell[0],c=cell[1];
            //4 directions
            for(int d[]:dirs){
                    int newRow=r+d[0];
                    int newCol=c+d[1];
                    if(isValid(newRow,newCol,grid)&&!visited[newRow][newCol]){
                        q.offerLast(new int[]{newRow,newCol});
                        visited[newRow][newCol]=true;
                    }
            }
        }
    }
    boolean isValid(int row,int col,char[][] grid){
        if(row<grid.length&&row>=0){
            if(col>=0&&col<grid[row].length){
                if(grid[row][col]=='1')
                return true;
            }
        }
        return false;
    }
}