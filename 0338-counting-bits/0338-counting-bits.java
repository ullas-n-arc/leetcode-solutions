class Solution {
    //10111
    //
    int[] dp;
    public int[] countBits(int n) {
        if(n==0) return new int[]{0};
        dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=1;i<n+1;i++){
            dp[i]=(i&1)+dp[i>>1];
        }
        return dp;
    }
}