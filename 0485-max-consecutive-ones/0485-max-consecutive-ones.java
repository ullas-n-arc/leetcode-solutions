class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int left=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==1){
            max=Math.max(max,right-left+1);
            }else{
                left=right+1;
            }
        }
        return max;
    }
}