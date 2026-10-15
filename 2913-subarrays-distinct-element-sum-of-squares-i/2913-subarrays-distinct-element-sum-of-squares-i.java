class Solution {
    public int sumCounts(List<Integer> nums) {
        int sum=0;
        for(int i=0;i<nums.size();i++){
            HashSet<Integer> mySet=new HashSet<>();
            for(int j=i;j<nums.size();j++){
                mySet.add(nums.get(j));
                sum+=(mySet.size()*mySet.size());
            }
            
        }
        return sum;
    }
}