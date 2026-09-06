class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int degree=-1;
        List<Integer> elements=new ArrayList<>();//all elements which have highest deg.
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int value=entry.getValue();
            if(value>degree){
                elements.clear();
                degree=value;
                elements.add(entry.getKey());
            }else if(value==degree){
                elements.add(entry.getKey());
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int ele:elements){
            int firstSeen=-1;
            int lastSeen=-1;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==ele){
                    if(firstSeen==-1){
                        firstSeen=i;
                        lastSeen=i;
                    }else{
                        lastSeen=i;
                    }
                }
            }
            ans=Math.min(ans,lastSeen-firstSeen+1);
        }
        return ans;
    }
}