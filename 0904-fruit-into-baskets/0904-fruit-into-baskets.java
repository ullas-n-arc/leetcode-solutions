class Solution {
    public int totalFruit(int[] fruits) {
        int left=0;
        int right=0;
        int maxi=0;
        HashMap<Integer,Integer> map=new HashMap<>();//element->last seen
        for(right=0;right<fruits.length;right++){
            map.put(fruits[right],right);
            if(map.size()>2){
                int min=Integer.MAX_VALUE;
                int key=0;
                for(Map.Entry<Integer,Integer> entry:map.entrySet()){
                    if(entry.getValue()<=min){
                        min=entry.getValue();
                        key=entry.getKey();
                    }
                }
                map.remove(key);
                left=min+1;
            }
            maxi=Math.max(maxi,right-left+1);

        }
        return maxi;
    }

}