class Solution {
    int dp[];
    public int climbStairs(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        solve(n);
        return dp[n];
    }
    int solve(int n){
        if(n==0) return 1;
        if(n<0) return 0;
        if(dp[n]!=-1){
            return dp[n];
        }
        return dp[n]=solve(n-1)+solve(n-2);
    }
}