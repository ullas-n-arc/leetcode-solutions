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
    public int[][] highestPeak(int[][] isWater) {
        int r=isWater.length;
        int c=isWater[0].length;
        int distance[][]=new int[r][c];
        boolean visited[][]=new boolean[r][c];
        Deque<Pair> q=new ArrayDeque<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(isWater[i][j]==1){
                    q.offerLast(new Pair(i,j,0));
                    visited[i][j]=true;
                }
            }
        }
        while(!q.isEmpty()){
            Pair p=q.pollFirst();
            int curRow=p.row;
            int curCol=p.col;
            int curDistance=p.dis;
            int[][] dirs={{-1,0},{1,0},{0,1},{0,-1}};
            for(int[] dir:dirs){
                int newRow=curRow+dir[0];
                int newCol=curCol+dir[1];
                if(isValid(newRow,newCol,r,c)&&!visited[newRow][newCol]){
                    visited[newRow][newCol]=true;
                    distance[newRow][newCol]=curDistance+1;
                    q.offerLast(new Pair(newRow,newCol,curDistance+1));
                }
            }
        }
        return distance;
    }
    boolean isValid(int r,int c,int R,int C){
        if(r<0||r>=R||c<0||c>=C){
            return false;
        }
        return true;
    }
}