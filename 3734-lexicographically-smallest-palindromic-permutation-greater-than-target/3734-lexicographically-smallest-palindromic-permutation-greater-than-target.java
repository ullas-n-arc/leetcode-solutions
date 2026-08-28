class Solution {
    char midChar='$';
    int halflen=0;
    String result="";
    public String lexPalindromicPermutation(String s, String target) {
        int n=s.length();
        int[] count=new int[26];
        for(char ch:s.toCharArray()){
            count[ch-'a']++;
        }
        int oddCount=0;
        for(int i=0;i<26;i++){
            if(count[i]%2==1){
                oddCount++;
                midChar=(char)(i+'a');
            }
        }
        if(oddCount>1){
            return "";
        }
        for(int i=0;i<26;i++){
            count[i]=count[i]/2;
        }
        halflen=n/2;
        solve(new StringBuilder(),count,target,0,false);
        return result;
    }
    boolean solve(StringBuilder sb,int[] count,String target,int i,boolean greater){
        if(sb.length()==halflen){
            StringBuilder candidate=new StringBuilder(sb);
            StringBuilder rightHalf=new StringBuilder(sb);
            rightHalf.reverse();
            if(midChar!='$'){
                candidate.append(midChar);
            }
            candidate.append(rightHalf);
            if(candidate.toString().compareTo(target)>0){
                result=candidate.toString();
                return true;
            }
            return false;
        }
        for(char ch='a';ch<='z';ch++){
            if(count[ch-'a']==0) continue;
            if(!greater&&ch<target.charAt(i)){
                continue;
            }
            int curLen=sb.length();
            sb.append(ch);
            count[ch-'a']--;
            boolean isGreater=greater||ch>target.charAt(i);
            if(solve(sb,count,target,i+1,isGreater)){
                return true;
            }
            sb.setLength(curLen);
            count[ch-'a']++;
        }
        return false;
    }
}