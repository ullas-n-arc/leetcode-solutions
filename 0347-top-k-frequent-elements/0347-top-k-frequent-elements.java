class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int ans[]=new int[k];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            pq.offer(new int[]{entry.getKey(),entry.getValue()});
            if(pq.size()>k){
                pq.poll();
            }
        }
        for(int i=0;i<k;i++){
            ans[i]=pq.poll()[0];
        }
        return ans;   
    }
}