class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        dp=new int[prices.length+1][2];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return solve(prices,0,1);
    }
    int solve(int[] prices,int i,int buy){
        if(i>=prices.length) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        if(buy==1){
            int pick=-prices[i]+solve(prices,i+1,0);
            int notPick=solve(prices,i+1,1);
            return dp[i][buy]=Math.max(pick,notPick);
        }else{
            int sell=prices[i]+solve(prices,i+2,1);
            int notSell=solve(prices,i+1,0);
            return dp[i][buy]=Math.max(sell,notSell);
        }
    }
}