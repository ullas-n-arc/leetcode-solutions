class Solution {
    int n,m;
    int[][][] dp;
    public boolean hasValidPath(char[][] grid) {
        n=grid.length;
        m=grid[0].length;
        //balanced paranthesis is alwyas even 
        //so our path lenngth is m+n-1
        if((m+n-1)%2!=0){
            return false;
        }
        dp=new int[n][m][n+m-1];
        for(int[][] twoD:dp){
            for(int[] row:twoD){
                Arrays.fill(row,-1);
            }
        }
        if(grid[0][0]==')'||grid[n-1][m-1]=='(') return false;
        return solve(0,0,0,grid)==1;
    }
    int solve(int i,int j,int openCount,char[][] grid){
        openCount+=(grid[i][j]=='(')?1:-1; 
        if(openCount<0){
            return 0;
        }
        if(dp[i][j][openCount]!=-1){
            return dp[i][j][openCount];
        }
        if(i==n-1&&j==m-1) {
            return dp[i][j][openCount]=(openCount==0?1:0);
        }
        if(i+1<n){
            if(solve(i+1,j,openCount,grid)==1){
                return dp[i][j][openCount]=1;
            }
        }
        if(j+1<m){
            if(solve(i,j+1,openCount,grid)==1){
                return dp[i][j][openCount]=1;
            }
        }
        return dp[i][j][openCount]=0;
    }
}