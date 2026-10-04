class Solution {
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        dp=new int[amount+1];
        Arrays.fill(dp,-1);
        int ans=solve(coins,amount);
        return ans>=Integer.MAX_VALUE-1?-1:ans;
    }
    int solve(int[] coins,int target){
        if(target==0){
            return 0;
        }
        if(target<0){
            return Integer.MAX_VALUE-1;
        }
        if(dp[target]!=-1) return dp[target];
        int result=Integer.MAX_VALUE-1;
        for(int coin:coins){
            result=Math.min(result,1+solve(coins,target-coin));
        }
        return dp[target]=result;
    }
}