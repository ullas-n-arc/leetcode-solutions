class Solution {
    class Pair{
        int row;
        int col;
        int dist;
        Pair(int _row,int _col,int _dist){
            row=_row;
            col=_col;
            dist=_dist;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int r=heights.length;
        int c=heights[0].length;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
            return Integer.compare(a.dist,b.dist);
        });
       int[][] effort=new int[r][c];
       for(int row[]:effort){
        Arrays.fill(row,Integer.MAX_VALUE);
       }
       effort[0][0]=0;
       pq.offer(new Pair(0,0,0));
       int dirs[][]={{-1,0},{0,1},{1,0},{0,-1}};
       while(!pq.isEmpty()){
            Pair p=pq.poll();
            int curRow=p.row;
            int curCol=p.col;
            int curEffort=p.dist;
            for(int dir[]:dirs){
                int newRow=curRow+dir[0];
                int newCol=curCol+dir[1];
                if(isValid(newRow,newCol,r,c)){
                    int newEffort=Math.max(curEffort,Math.abs(heights[curRow][curCol]-heights[newRow][newCol]));
                    if(newEffort<effort[newRow][newCol]){
                        effort[newRow][newCol]=newEffort;
                        pq.offer(new Pair(newRow,newCol,newEffort));
                    }
                    
                }
            }
       }
       return effort[r-1][c-1];
    }
    boolean isValid(int r,int c,int R,int C){
        if(r<0||r>=R||c<0||c>=C) return false;
        return true;
    }
}