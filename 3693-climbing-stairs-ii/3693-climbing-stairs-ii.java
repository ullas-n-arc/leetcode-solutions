class Solution {
     Integer dp[];
    public int climbStairs(int n, int[] costs) {
        dp= new Integer [n+1];
        int ans = get(0,n,costs);  

        return ans;      
    }
    public  int get(int s, int n , int [] cost){
        if(s==n){
            return 0;
        }
        if(dp[s]!=null) return dp[s];
        int c2 = Integer.MAX_VALUE;
        int c1 = Integer.MAX_VALUE;
        int c3 = Integer.MAX_VALUE;

        if(s+1<=n){
            c1=  cost[s] + 1 + get(s + 1, n, cost);
        }
        if(s+2<=n){
            c2=   cost[s+1] + 4 + get(s + 2, n, cost);
        }
        if(s+3<=n){
            c3= cost[s+2] + 9 + get(s + 3, n, cost);
        
        }
        return dp[s]=Math.min( c1, Math.min(c2,c3));
    }
}