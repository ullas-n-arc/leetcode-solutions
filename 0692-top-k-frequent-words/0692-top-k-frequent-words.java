class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> freq=new HashMap<>();
        for(String word:words){
            freq.put(word,freq.getOrDefault(word,0)+1);
        }
        PriorityQueue<String> heap=new PriorityQueue<>((a,b)->{
            if(freq.get(a).equals(freq.get(b))){
                return b.compareTo(a);
            }
            return freq.get(a)-freq.get(b);
        });
        for(Map.Entry<String,Integer> entry:freq.entrySet()){
            heap.offer(entry.getKey());
            if(heap.size()>k){
                heap.poll();
            }
        }
        List<String> res=new ArrayList<>();
        while(!heap.isEmpty()){
            res.add(heap.poll());
        }
        Collections.reverse(res);
        return res;

    }
}