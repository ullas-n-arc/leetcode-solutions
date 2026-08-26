class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] t=new int[nums.length];
        t[0]=nums[0];
        t[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            int rob=nums[i]+t[i-2];
            int skip=t[i-1];
            t[i]=Math.max(rob,skip);
        }
        return t[nums.length-1];
    }
}