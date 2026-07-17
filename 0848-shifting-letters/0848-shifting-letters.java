class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        //i -> 0 to n
        //0 -> {0,0}
        //1->{0,1}
        //2->{0,2} starting is same which is 0 ending is different
        //diffArray[0]+=x
        //diffArray[i+1]-=x; //i+1<n
        int n=s.length();
        int[] diffArray=new int[n];
        for(int i=0;i<n;i++){
            diffArray[0]=(diffArray[0]+shifts[i])%26;
            if(i+1<n)
            diffArray[i+1]=(diffArray[i+1]-shifts[i])%26;
        }
        for(int i=1;i<n;i++){
            diffArray[i]=((diffArray[i]+diffArray[i-1])%26+26)%26;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            int originalPos=s.charAt(i)-'a';
            int newPos=(((originalPos+diffArray[i])%26)+26)%26;
            sb.append((char)('a'+newPos));
        }
        return sb.toString();
    }
}