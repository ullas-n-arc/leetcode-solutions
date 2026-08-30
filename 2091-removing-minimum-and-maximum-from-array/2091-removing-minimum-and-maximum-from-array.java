class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int min=0;
        int max=0;
        for(int i=0;i<n;i++){
            if(nums[i]<nums[min]){
                min=i;
            }
            if(nums[i]>nums[max]){
                max=i;
            }
        }
        //4 cases
        //removing from only front
        int cost1=Math.max(max,min)+1;
        //removing from only back
        int cost2=n-Math.min(max,min);
        //one from front one from back
        //subcase 1 removing max from front and min from back
        int cost3=(max+1)+(n-min);
        //subcase 2 removing min from front and max from back
        int cost4=(min+1)+(n-max);
        
        return Math.min(Math.min(cost1,cost2),Math.min(cost3,cost4));
        
    }
}