class Solution {
    int[] dp;
    public int numSquares(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n);
    }
    int solve(int target){
        if(target==0){
            return 0;
        }
        if(target<0){
            return Integer.MAX_VALUE-1;
        }
        if(dp[target]!=-1) return dp[target];
        int result=Integer.MAX_VALUE;
        for(int i=1;i*i<=target;i++){
            result=Math.min(result,1+solve(target-i*i));
        }
        return dp[target]=result;
    }
}