class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int maxCount=0;
        for(int num:nums){
            if(num!=1){
                count=0;
            }else{
            count++;
            }
            maxCount=Math.max(maxCount,count);
        }
        return maxCount;
    }
}