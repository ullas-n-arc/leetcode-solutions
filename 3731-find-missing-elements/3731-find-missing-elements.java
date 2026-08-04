class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        //smallest and largest are present
        //largest - smallest should be length of nums ideally
        List<Integer> res=new ArrayList<>();
        int min=nums[0];
        int max=nums[0];
        Set<Integer> mySet=new HashSet<>();
        for(int num:nums){
            mySet.add(num);
            min=Math.min(min,num);
            max=Math.max(max,num);
        }
        if(nums.length==max-min+1){
            return res;
        }
        for(int i=min+1;i<max;i++){
            if(!mySet.contains(i)){
                res.add(i);
            }
        }
        return res;        
    }
}