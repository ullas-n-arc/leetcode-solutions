class Solution {
    Boolean[] dp;
    public boolean divisorGame(int n) {
        dp=new Boolean[n+1];
        return solve(n);   
    }
    boolean solve(int n){
        if(n<=1) return false;
        if(dp[n]!=null) return dp[n];
        for(int i=1;i<=n/2;i++){
            if(n%i==0&&!solve(n-i))// because solve(n-i) refers to other player , he should loose so i can win
            return dp[n]=true;
        }
        return dp[n]=false;
    }
}