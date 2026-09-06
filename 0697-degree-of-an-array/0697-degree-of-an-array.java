class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        HashMap<Integer,Integer> firstSeen=new HashMap<>();
        HashMap<Integer,Integer> lastSeen=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            firstSeen.putIfAbsent(nums[i],i);
            lastSeen.put(nums[i],i);
        }
        int degree=-1;
        int ans=Integer.MAX_VALUE; 
        ArrayList<Integer> elements=new ArrayList<>();   
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
        for(int ele:elements){
            ans=Math.min(ans,lastSeen.get(ele)-firstSeen.get(ele)+1);
        }
        return ans;
    }
}