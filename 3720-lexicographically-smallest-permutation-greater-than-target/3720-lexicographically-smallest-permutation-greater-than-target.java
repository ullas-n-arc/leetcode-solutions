class Solution {
    String result="";
    public String lexGreaterPermutation(String s, String target) {
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        StringBuilder current=new StringBuilder();
        solve(current,freq,target,0,false);
        return result;
    }
    boolean solve(StringBuilder current,int[] freq,String target,int i,boolean isGreater){
        if(i==target.length()){
            if(isGreater){
                result=current.toString();
                return true;
            }
            return false;
        }
        for(char ch='a';ch<='z';ch++){
            if(freq[ch-'a']==0)continue;
            if(isGreater==false&&ch<target.charAt(i))continue;
            int curLen=current.length();
            current.append(ch);
            freq[ch-'a']--;
            boolean greater=isGreater||ch>target.charAt(i);
            if(solve(current,freq,target,i+1,greater)){
                return true;
            }
            current.setLength(curLen);
            freq[ch-'a']++;     
        }
        return false;
    }
}