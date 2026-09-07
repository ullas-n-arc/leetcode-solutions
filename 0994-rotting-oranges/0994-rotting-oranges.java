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
        int n=grid.length;
        int m=grid[0].length;
        int time=0;
        Deque<Pair> q=new ArrayDeque<>();
        boolean[][] visited=new boolean[n][m];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.offerLast(new Pair(i,j,0));
                    visited[i][j]=true;
                }
            }
        }
        while(!q.isEmpty()){
            Pair p=q.pollFirst();
            int curRow=p.row;
            int curCol=p.col;
            int curTime=p.time;
            int dirs[][]={
                {-1,0},
                {1,0},
                {0,1},
                {0,-1}
            };
            for(int dir[]:dirs){
                int newRow=curRow+dir[0];
                int newCol=curCol+dir[1];
                if(isValid(newRow,newCol,n,m)&&!visited[newRow][newCol]&&grid[newRow][newCol]==1){
                    visited[newRow][newCol]=true;
                    q.offerLast(new Pair(newRow,newCol,curTime+1));
                }
            }
            time=Math.max(time,curTime);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1&&visited[i][j]==false){
                    return -1;
                }
            }
        }
        return time;
    }
    boolean isValid(int r,int c,int R,int C){
        if(r<0||c<0||r>=R||c>=C) return false;
        return true;
    }
}