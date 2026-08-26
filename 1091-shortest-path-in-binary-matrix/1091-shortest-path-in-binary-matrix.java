class Solution {
    class Pair{
        int row;
        int col;
        int dis;
        Pair(int row,int col,int dis){
            this.row=row;
            this.col=col;
            this.dis=dis;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1) return -1;
        Deque<Pair> q=new ArrayDeque<>();
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        visited[0][0]=true;
        q.offerLast(new Pair(0,0,0));
        while(!q.isEmpty()){
            Pair p=q.pollFirst();
            int row=p.row;
            int col=p.col;
            int dist=p.dis;
            if(row==grid.length-1&&col==grid[0].length-1) return dist+1;
            int dir[][]={{-1,0},{1,0},{0,1},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
            for(int d[]:dir){
                int r=row+d[0];
                int c=col+d[1];
                if(isValid(r,c,grid.length,grid[0].length)&&!visited[r][c]&&grid[r][c]==0){
                    visited[r][c]=true;
                    q.offerLast(new Pair(r,c,dist+1));
                }
            }
        }
        return -1;
    }
    boolean isValid(int r,int c,int R,int C){
        if(r<0||c<0||r>=R||c>=C){
            return false;
        }
        return true;
    }
}