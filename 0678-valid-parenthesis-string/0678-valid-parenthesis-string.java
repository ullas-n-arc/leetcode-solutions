class Solution {
    Boolean[][] dp;
    public boolean checkValidString(String s) {
        int n=s.length();
        dp=new Boolean[n][n+1];
        return solve(s,0,0);
    }
    boolean solve(String s,int balance,int i){
        if(balance<0) return false;
        if(i==s.length()) {
            if(balance==0) return true;
            return false;
        }
        if(dp[i][balance]!=null) return dp[i][balance];
        if(s.charAt(i)=='('){
            return dp[i][balance]=solve(s,balance+1,i+1);
        }else if(s.charAt(i)==')'){
            return dp[i][balance]=solve(s,balance-1,i+1);
        }else{
            return dp[i][balance]=solve(s,balance,i+1)||solve(s,balance+1,i+1)||solve(s,balance-1,i+1);
        }
    }
}