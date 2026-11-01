class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        int min=nums[0];
        int[] diff=new int[n];
        int sum=0;
        for(int num:nums){
            min=Math.min(min,num);
        }
        for(int i=0;i<n;i++){
            diff[i]=nums[i]-min;
        }
        for(int num:diff){
            sum+=num;
        }
        return sum;
    }
}