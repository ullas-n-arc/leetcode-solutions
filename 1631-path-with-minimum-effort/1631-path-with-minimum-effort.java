class Solution {
    int minEffort=Integer.MAX_VALUE;
    int[][] dirs={{-1,0},{1,0},{0,1},{0,-1}};
    class Pair{
        int row;
        int col;
        int effort;
        Pair(int row,int col,int effort){
            this.row=row;
            this.col=col;
            this.effort=effort;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Integer.compare(a.effort,b.effort));
        int[][] effort=new int[n][m];
        for(int row[]:effort){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        effort[0][0]=0;
        pq.offer(new Pair(0,0,0));
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int row=p.row;
            int col=p.col;
            int curEffort=p.effort;
            for(int dir[]:dirs){
                int newRow=row+dir[0];
                int newCol=col+dir[1];
                if(isValid(newRow,newCol,n,m)){
                    int newEffort=Math.max(curEffort,Math.abs(heights[row][col]-heights[newRow][newCol]));
                    if(newEffort<effort[newRow][newCol]){
                        effort[newRow][newCol]=newEffort;
                        pq.offer(new Pair(newRow,newCol,newEffort));
                    }
                }
            }
        }
        return effort[n-1][m-1];
    }
    
    boolean isValid(int r,int c,int R,int C){
        if(r>=R||c>=C||r<0||c<0){
            return false;
        }
        return true;
    }
}