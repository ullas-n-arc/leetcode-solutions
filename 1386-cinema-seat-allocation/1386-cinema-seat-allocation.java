class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int row[]:reservedSeats){
            map.put(row[0],map.getOrDefault(row[0],0)|(1<<row[1]));
        }
        int result=(n-map.size())*2;
        int groupAMask=(1<<2)|(1<<3)|(1<<4)|(1<<5);
        int groupBMask=(1<<4)|(1<<5)|(1<<6)|(1<<7);
        int groupCMask=(1<<6)|(1<<7)|(1<<8)|(1<<9);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int row=entry.getKey();
            int bitmask=entry.getValue();
            boolean groupA=(groupAMask&bitmask)==0;
            boolean groupB=(groupBMask&bitmask)==0;
            boolean groupC=(groupCMask&bitmask)==0;
            if(groupA&&groupC){
                result+=2;
            }else if(groupA||groupB||groupC){
                result+=1;
            }
        }
        return result;
    }
}