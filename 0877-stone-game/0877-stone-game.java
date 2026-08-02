class Solution {
    int[][] t;
    public boolean stoneGame(int[] piles) {
        t=new int[piles.length][piles.length];
        for(int row[]:t){
            Arrays.fill(row,-1);
        }
        int sum=0;
        for(int pile:piles){
            sum+=pile;
        }
        sol(piles,0,piles.length-1);
        return t[0][piles.length-1]>sum-t[0][piles.length-1];
    }
    int sol(int[] piles,int i,int j){
        if(t[i][j]!=-1){
            return t[i][j];
        }
        if(i==j){
            return t[i][j]=piles[i];
        }
        if(i+1==j){
            return t[i][j]=Math.max(piles[i],piles[j]);
        }
        return t[i][j]=Math.max(piles[i]+Math.min(sol(piles,i+1,j-1),sol(piles,i+2,j)),piles[j]+Math.min(sol(piles,i,j-2),sol(piles,i+1,j-1)));
    }
}