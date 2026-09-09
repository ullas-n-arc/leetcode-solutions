class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> mySet=new HashSet<>(k);
        int left=0;
        for(int right=0;right<nums.length;right++){
            if(mySet.contains(nums[right])) return true;
            mySet.add(nums[right]);
            if(right-left>=k){
                mySet.remove(nums[left]);
                left++;
            }
        }
        return false;
    }
}