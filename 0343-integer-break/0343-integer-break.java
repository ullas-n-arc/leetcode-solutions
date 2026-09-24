class Solution {
    int dp[];
    int m;
    public int integerBreak(int n) {
        dp=new int[n+1];
        m=n;
        Arrays.fill(dp,-1);
        solve(n);
        return dp[n];
    }
    int solve(int target){
        if(target==0){
            return  1;
        }
        if(target<0){
            return -1;
        }
        if(dp[target]!=-1) return dp[target];
        int res=Integer.MIN_VALUE;
        for(int i=1;i<m;i++){
            res=Math.max(res,i*solve(target-i));
        }
        return dp[target]=res;
    }
}