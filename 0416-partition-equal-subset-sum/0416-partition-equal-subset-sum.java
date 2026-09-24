class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0){
            return false;
        }
        int target=sum/2;
        dp=new Boolean[nums.length][sum/2+1];
        solve(nums,nums.length-1,sum/2);
        return dp[nums.length-1][sum/2];
    }
    boolean solve(int[] nums,int i,int target){
        if(target==0){
            return true;
        }
        if(i<0||target<0){
            return false;
        }
        if(dp[i][target]!=null) return dp[i][target];
        dp[i][target]=solve(nums,i-1,target);
        if(target>=nums[i]){
            dp[i][target]=dp[i][target]||solve(nums,i-1,target-nums[i]);
        }
        return dp[i][target];
    }
}