class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> myset=new HashSet<>();
        for(int num:nums){
            if(myset.contains(num)){
                return true;
            }
            myset.add(num);
        }
        return false;
    }
}