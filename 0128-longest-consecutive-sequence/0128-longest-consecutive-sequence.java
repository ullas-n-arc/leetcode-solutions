class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Set<Integer> mySet=new HashSet<>();
        for(int num:nums){
            mySet.add(num);
        }
        int maxCount=0;
        int count=0;
        for(int num:nums){
            count=0;
            if(!mySet.contains(num-1)){//beginning
                int start=num;
                while(mySet.contains(start)){
                    mySet.remove(start);
                    start++;
                    count++;
                }
            }
            maxCount=Math.max(maxCount,count);
        }
        return maxCount;
    }
}