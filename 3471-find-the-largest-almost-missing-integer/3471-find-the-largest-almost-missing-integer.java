class Solution {
    public int largestInteger(int[] nums, int k) {
        int max=-1;
        if(k==nums.length){
            for(int num:nums){
                max=Math.max(num,max);
            }
            return max;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        if(k==1){
            int ans=-1;
            for(int num:map.keySet()){
                if(map.get(num)==1){
                    ans=Math.max(ans,num);
                }
            }
            return ans;
        }else{
           /* Any element in the middle of the array (from index 1 to n-2  is naturally overlapped and covered by at least two subarrays of size k */
           int ans=-1;
           if(map.get(nums[0])==1){
            ans=Math.max(ans,nums[0]);
           }
           if(map.get(nums[nums.length-1])==1){
            ans=Math.max(ans,nums[nums.length-1]);
           }
           return ans;
        }   
    }
}