class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int countOne=0;
        for(char ch:s.toCharArray()){
            if(ch=='1') countOne++;
        }
        ArrayList<Integer> zeroBlock=new ArrayList<>();
        int count=0;
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)=='0'){
                while(i<s.length()&&s.charAt(i)=='0'){
                    count++;
                    i++;
                }
                zeroBlock.add(count);
            }else{
                count=0;
                i++;
            }
            
        }
        int maxBlock=0;
        for(i=0;i<zeroBlock.size()-1;i++){
            maxBlock=Math.max(maxBlock,zeroBlock.get(i)+zeroBlock.get(i+1));
        }
        return maxBlock+countOne;
    }
}