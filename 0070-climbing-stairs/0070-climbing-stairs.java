class Solution {
    int[] memo;
    public int climbStairs(int n) {
        memo=new int[n+1];
        solve(n);
        return memo[n];
    }
    int solve(int n){
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        if(memo[n]!=0){
            return memo[n];
        }
        return memo[n]=solve(n-1)+solve(n-2);
    }
}