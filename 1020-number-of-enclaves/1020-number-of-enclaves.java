class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int numEnclaves(int[][] grid) {
        Deque<Pair> q=new ArrayDeque<>();
        boolean visited[][]=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(i==0||i==grid.length-1||j==0||j==grid[i].length-1){
                    if(grid[i][j]==1){
                        q.offerLast(new Pair(i,j));
                        visited[i][j]=true;
                    }
                }
            }
        }
        while(!q.isEmpty()){
            Pair p=q.pollFirst();
            int row=p.row;
            int col=p.col;
            int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
            for(int d[]:dir){
                int newRow=row+d[0];
                int newCol=col+d[1];
                if(newRow>=0&&newRow<grid.length&&newCol>=0&&newCol<grid[0].length&&visited[newRow][newCol]==false&&grid[newRow][newCol]==1){
                    visited[newRow][newCol]=true;
                    q.offerLast(new Pair(newRow,newCol));
                }
            }
        }
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1&&visited[i][j]==false){
                    count++;
                }
            }
        }
        return count;
    }
}