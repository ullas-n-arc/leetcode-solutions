class Solution {
    public int countIslands(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]>0){
                    long sum=dfs(i,j,grid);
                    if(sum%k==0)count++;
                }
            }
        }
        return count;
    }
    long dfs(int r,int c,int[][] grid){
        int[][] dirs={{-1,0},{1,0},{0,1},{0,-1}};
        long sum=grid[r][c];
        grid[r][c]=0;
        for(int dir[]:dirs){
            int newRow=r+dir[0];
            int newCol=c+dir[1];
            if(isValid(newRow,newCol,grid.length,grid[0].length)&&grid[newRow][newCol]>0){
                sum+=dfs(newRow,newCol,grid);
            }
        }
        return sum;
    }
    boolean isValid(int r,int c,int R,int C){
        if(r<0||r>=R||c<0||c>=C){
            return false;
        }
        return true;
    }
}