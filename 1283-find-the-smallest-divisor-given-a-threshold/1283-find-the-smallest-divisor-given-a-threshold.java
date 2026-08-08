class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        //binary search on answer on divisor
        int ans=-1;
        int left=1;
        int right=0;
        for(int num:nums){
            right=Math.max(num,right);
        }
        while(left<=right){
            int mid=left+(right-left)/2;
            if(isFeasible(nums,mid,threshold)){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
    public boolean isFeasible(int[] nums,int divisor,int threshold){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=Math.ceil((double)nums[i]/divisor);
        }
        return sum<=threshold;
    }
}