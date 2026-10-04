class Solution {
    int[] dp;
    public int numDecodings(String s) {
        int n=s.length();
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(s,0);
    }
    int solve(String s,int i){
        if(i==s.length()){
            return 1;
        }
        if(s.charAt(i)=='0'){
            return 0;
        }
        if(dp[i]!=-1) return dp[i];
        int ways=solve(s,i+1);
        if(i+1<s.length()){
            int num=Integer.parseInt(s.substring(i,i+2));
            if(num>=10&&num<=26){
                ways+=solve(s,i+2);
            }
        }
        return dp[i]=ways;
    }
}