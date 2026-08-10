class Solution {
    boolean[] t;//0 mwans loose 1 means win
    public boolean winnerSquareGame(int n) {
        t=new boolean[n+1];
        for(int i=0;i<n+1;i++){
            for(int k=1;k*k<=i;k++){
                if(t[i-k*k]==false){
                    t[i]=true;
                }
            }
        }
        return t[n];
    }
}