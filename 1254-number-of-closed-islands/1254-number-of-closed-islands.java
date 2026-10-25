class Solution {
    public int closedIsland(int[][] grid) {
        int row=grid.length,col=grid[0].length;
        int count=0;
        boolean[][] visited=new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==0&&!visited[i][j]){
                    if(bfs(i,j,grid,visited)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    boolean bfs(int x,int y,int[][] grid,boolean[][] visited){
        Deque<Pair> q=new ArrayDeque<>();
        q.offerLast(new Pair(x,y));
        visited[x][y]=true;
        int[][] dirs={{-1,0},{1,0},{0,1},{0,-1}};
        boolean closed=true;
        while(!q.isEmpty()){
            Pair p=q.pollFirst();
            int row=p.row;
            int col=p.col;
            if(row==0||row==grid.length-1||col==0||col==grid[0].length-1){
                closed=false;
            }
            for(int dir[]:dirs){
                int newRow=row+dir[0];
                int newCol=col+dir[1];
                if(isValid(newRow,newCol,grid.length,grid[0].length)&&!visited[newRow][newCol]&&grid[newRow][newCol]==0){
                    visited[newRow][newCol]=true;
                    q.offerLast(new Pair(newRow,newCol));
                }
            }
        }
        return closed;
    }
    boolean isValid(int r,int c,int R,int C){
        if(r<0||r>=R||c<0||c>=C) return false;
        return true;
    }
    class Pair{
        int row;
        int col;
        Pair(int r,int c){
            row=r;
            col=c;
        }
    }
}