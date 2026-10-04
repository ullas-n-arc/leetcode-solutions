class Solution {
    int dp[];
    public int numTrees(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n);
    }
    int solve(int n){
        if(n<0) return 0;
        if(n==0){
            return 1;
        }
        if(dp[n]!=-1) return dp[n];
        int currentWays=0;
        for(int i=0;i<n;i++){
            int left=solve(i);
            int right=solve(n-i-1);
            currentWays+=left*right;
        }
        return dp[n]=currentWays;
    }
}