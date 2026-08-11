class Solution {
    public int missingInteger(int[] nums) {
        if(nums.length==1){
            return nums[0]+1;
        }
        HashSet<Integer> mySet=new HashSet<>();
        for(int num:nums){
            mySet.add(num);
        }
        // int maxSum=0;
        // int sum=0;
        // sum=nums[0];
        // maxSum=nums[0];
        // for(int right=1;right<nums.length;right++){
        //     if(nums[right]==nums[right-1]+1){
        //         sum+=nums[right];
        //     }else{
        //         sum=nums[right];
        //     }
        //     maxSum=Math.max(maxSum,sum);
        // }
        // for(int i=maxSum;;i++){
        //     if(!mySet.contains(i)){
        //         return i;
        //     }
        // }
        // i missed the part they told prefix containing nums[0] is sequential
        int sum=nums[0];
        int i=1;
        for(i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1){
                sum+=nums[i];
            }else{
                break;
            }
        }
        if(i==nums.length){
            return sum;
        }
        for(i=sum;;i++){
            if(!mySet.contains(i)){
                return i;
            }
        }
    }
}