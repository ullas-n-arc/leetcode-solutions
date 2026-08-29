class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n=nums.length;
        int[] vec=Arrays.copyOf(nums,nums.length);
        Arrays.sort(vec);
        int groupNum=0;
        HashMap<Integer,Integer> numToGroup=new HashMap<>();
        numToGroup.put(vec[0],groupNum);
        HashMap<Integer,ArrayDeque<Integer>> groupToList=new HashMap<>();
        groupToList.computeIfAbsent(groupNum,k->new ArrayDeque<>());
        groupToList.get(groupNum).offer(vec[0]);
        for(int i=1;i<n;i++){
            if(Math.abs(vec[i]-vec[i-1])>limit){
                groupNum++;
            }
            numToGroup.put(vec[i],groupNum);
            groupToList.computeIfAbsent(groupNum,k->new ArrayDeque<>());
            groupToList.get(groupNum).offer(vec[i]);
        }
        //building the answer (merging groups)
        for(int i=0;i<n;i++){
            int num=nums[i];
            int group=numToGroup.get(num);
            //smallest available number in this group
            nums[i]=groupToList.get(group).poll();
        }
        return nums;
    }
}