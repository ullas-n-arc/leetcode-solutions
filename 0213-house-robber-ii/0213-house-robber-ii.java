class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int[] dp1=new int[n];
        int[] dp2=new int[n];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        return Math.max(solve(nums,0,n-2,dp1),solve(nums,1,n-1,dp2));
    }
    int solve(int[] nums,int i,int j,int[] dp){
        if(i>j){
            return 0;
        }
        if(i==j){
            return nums[i];
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int rob=nums[i]+solve(nums,i+2,j,dp);
        int skip=solve(nums,i+1,j,dp);
        return dp[i]=Math.max(rob,skip);
    }
}