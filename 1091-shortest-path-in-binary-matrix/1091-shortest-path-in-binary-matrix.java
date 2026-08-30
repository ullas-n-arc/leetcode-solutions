class Solution {
    class Pair{
        int row;
        int col;
        int dist;
        Pair(int row,int col,int dis){
            this.row=row;
            this.col=col;
            this.dist=dis;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if(grid[0][0]==1) return -1;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
            if(a.dist==b.dist){
                Integer.compare(a.row,b.row);
            }
            return Integer.compare(a.dist,b.dist);
        }
        );
        pq.offer(new Pair(0,0,0));
        int[][] dist=new int[n][m];
        for(int row[]:dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        dist[0][0]=0;
        while(!pq.isEmpty()){
            Pair pair=pq.poll();
            int row=pair.row;
            int col=pair.col;
            int curDis=pair.dist;
            int[][] dirs={{-1,0},{1,0},{0,1},{0,-1},{-1,-1},{-1,1},{1,1},{1,-1}};
            for(int dir[]:dirs){
                int newRow=row+dir[0];
                int newCol=col+dir[1];
                if(isValid(newRow,newCol,n,m)&&grid[newRow][newCol]==0&&1+curDis<dist[newRow][newCol]){
                    dist[newRow][newCol]=curDis+1;
                    pq.offer(new Pair(newRow,newCol,curDis+1));
                }
            }
        }
        if(dist[n-1][m-1]==Integer.MAX_VALUE){
            return -1;
        }
        return dist[n-1][m-1]+1;
    }
    boolean isValid(int r,int c,int R,int C){
        if(r<0||c<0||r>=R||c>=C){
            return false;
        }
        return true;
    }
}