class Solution {
    public void solve(char[][] board) {
        // i feel this problem is opposite of number of enclaves
        boolean[][] visited=new boolean[board.length][board[0].length];
        Deque<int[]> q=new ArrayDeque<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(i==0||i==board.length-1||j==0||j==board[0].length-1){
                    if(board[i][j]=='O'){
                        q.offerLast(new int[]{i,j});
                        visited[i][j]=true;
                    }
                }
            }
        }
        while(!q.isEmpty()){
            int[] a=q.pollFirst();
            int r=a[0];
            int c=a[1];
            int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};
            for(int d[]:dir){
                int row=r+d[0];
                int col=c+d[1];
                if(row>=0&&row<board.length&&col>=0&&col<board[0].length&&board[row][col]=='O'&&visited[row][col]==false){
                    q.offerLast(new int[]{row,col});
                    visited[row][col]=true;
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]=='O'&&visited[i][j]==false){
                    board[i][j]='X';
                }
            }
        }
    }
}