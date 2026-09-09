class Solution {
    int t[];
    public int lengthOfLIS(int[] nums) {
        t=new int[nums.length];
        Arrays.fill(t,-1);
        int ans=1;
        for(int i=0;i<nums.length;i++){
            ans=Math.max(ans,solve(nums,i));
        }
        return ans;
    }
    int solve(int[] nums,int i){
        if(t[i]!=-1) return t[i];
        int ans=1;
        for(int j=0;j<i;j++){
            if(nums[j]<nums[i]){
                ans=Math.max(ans,1+solve(nums,j));
            }
        }
        return t[i]=ans;
    }
}