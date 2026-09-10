class Solution {
    int dp[][];
    public int longestCommonSubsequence(String text1, String text2) {
        dp=new int[text1.length()][text2.length()];
        for(int row[]:dp)Arrays.fill(row,-1);
        solve(text1,text2,text1.length()-1,text2.length()-1);
        return dp[text1.length()-1][text2.length()-1];
    }
    int solve(String text1,String text2,int i,int j){
        if(i<0) return 0;
        if(j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(text1.charAt(i)==text2.charAt(j)){
            return dp[i][j]=1+solve(text1,text2,i-1,j-1);
        }
        return dp[i][j]=Math.max(solve(text1,text2,i,j-1),solve(text1,text2,i-1,j));
    }
}