class Solution {
    public int numEnclaves(int[][] grid) {
        int[][] visited=new int[grid.length][grid[0].length];
        Deque<int[]> q=new ArrayDeque<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(i==0||i==grid.length-1||j==0||j==grid[i].length-1){
                    if(grid[i][j]==1)
                    q.offerLast(new int[]{i,j});
                    visited[i][j]=1;
                }
            }
        }
        while(!q.isEmpty()){
            int[] arr=q.pollFirst();
            int row=arr[0];
            int col=arr[1];
            int dr[]={-1,1,0,0};
            int dc[]={0,0,-1,1};
            for(int i=0;i<4;i++){
                int r=row+dr[i];
                int c=col+dc[i];
                if(r>=0&&r<grid.length&&c>=0&&c<grid[r].length&&grid[r][c]==1&&visited[r][c]!=1){
                    visited[r][c]=1;
                    q.offerLast(new int[]{r,c});
                }
            }
        }
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1&&visited[i][j]!=1){
                    count++;
                }
            }
        }
        return count;
    }
}