class Solution {
    public int[][] updateMatrix(int[][] mat) {
        //multi source bfs expand from 0
        Deque<int[]> q=new ArrayDeque<>();
        boolean[][] visited=new boolean[mat.length][mat[0].length];
        int distance[][]=new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==0){
                    q.offerLast(new int[]{i,j,0});
                    visited[i][j]=true;
                }
            }
        }
        while(!q.isEmpty()){
            int[] arr=q.pollFirst();
            int r=arr[0];
            int c=arr[1];
            int d=arr[2];
            int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
            for(int di[]:dir){
                int row=r+di[0];
                int col=c+di[1];
                if(row>=0&&row<mat.length&&col>=0&&col<mat[0].length&&visited[row][col]==false){
                    distance[row][col]=d+1;
                    q.offerLast(new int[]{row,col,d+1});
                    visited[row][col]=true;
                }
            }
        }
        return distance;
    }  
}