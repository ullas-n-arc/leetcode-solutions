class Solution {
    class Pair{
        int row;
        int col;
        int time;
        Pair(int row_,int col_,int time_){
            row=row_;
            col=col_;
            time=time_;
        }
    }
    public int orangesRotting(int[][] grid) {
        Deque<Pair> q=new ArrayDeque<>();
        int t=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                    q.offerLast(new Pair(i,j,0));
                }
            }
        }
        while(!q.isEmpty()){
            Pair p=q.pollFirst();
            int r=p.row;
            int c=p.col;
            int time=p.time;
            int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
            for(int d[]:dir){
                int row=r+d[0];
                int col=c+d[1];
                if(row>=0&&row<grid.length&&col>=0&&col<grid[row].length&&grid[row][col]==1){
                    grid[row][col]=2;
                    q.offerLast(new Pair(row,col,time+1));
                    t=Math.max(t,time+1);
                }
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return t;
    }
}