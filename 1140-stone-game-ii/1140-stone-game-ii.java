class Solution {
    int t[][][];
    public int stoneGameII(int[] piles) {
        int n=piles.length;
        t=new int[2][n+1][n+1];
        for(int row1[][]:t){
            for(int row2[]:row1){
                Arrays.fill(row2,-1);
            }
        }
        return solve(piles,n,1,0,1);
    }
    int solve(int[] piles,int n,int player,int i,int m){
        if(i>=n) return 0;
        if(t[player][i][m]!=-1){
            return t[player][i][m];
        }
        int result=-1;
        if(player==0){
            result=Integer.MAX_VALUE;
        }
        int stones=0;
        for(int x=1;x<=Math.min(2*m,n-i);x++){
            stones+=piles[i+x-1];
            if(player==1){
                result=Math.max(result,stones+solve(piles,n,0,i+x,Math.max(x,m)));
            }else{
                result=Math.min(result,solve(piles,n,1,i+x,Math.max(x,m)));
            }
        }
        return t[player][i][m]=result;
    }
}