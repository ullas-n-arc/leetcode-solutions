class Solution {
    public int totalFruit(int[] fruits) {
        int left=0;
        int n=fruits.length;
        TreeSet<Pair<Integer,Integer>> mySet=new TreeSet<>((a,b)->{
            int compareValue=Integer.compare(a.getValue(),b.getValue());
            if(compareValue==0){
                return Integer.compare(a.getKey(),b.getKey());
            }
            return compareValue;
        });//fruit,last_seen
        int maxLength=0;
        for(int right=0;right<n;right++){
            int currentFruit=fruits[right];
            //if the fruit alread exists remove its old position
            mySet.removeIf(pair->pair.getKey()==currentFruit);
            mySet.add(new Pair(currentFruit,right));
            if(mySet.size()>2){
                left=mySet.pollFirst().getValue()+1;
            }
            maxLength=Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }

}