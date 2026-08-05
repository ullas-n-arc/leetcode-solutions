class Solution {
    class Pair{
        int row;
        int col;
        int time;
        Pair(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int[][] visited=new int[rows][cols];
        Deque<Pair> q=new ArrayDeque<>();
        int time=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                    q.offerLast(new Pair(i,j,0));
                }
            }
        }
        while(!q.isEmpty()){
            Pair p=q.pollFirst();
            int r=p.row;
            int c=p.col;
            int t=p.time;
            time=Math.max(time,t);
            int[][] dirs={{-1,0},{1,0},{0,1},{0,-1}};
            for(int dir[]:dirs){
                int newRow=r+dir[0];
                int newCol=c+dir[1];
                if(isValid(newRow,newCol,grid,visited)){
                    q.offerLast(new Pair(newRow,newCol,t+1));
                    visited[newRow][newCol]=t+1;
                }
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1&&visited[i][j]==0) return -1;
            }
        }
        return time;
    }
    boolean isValid(int r,int c,int[][] grid,int[][] visited){
        if(r>=grid.length||r<0) return false;
        if(c>=grid[r].length||c<0) return false;
        if(grid[r][c]!=1) return false;
        if(visited[r][c]!=0) return false;
        return true;
    }
}