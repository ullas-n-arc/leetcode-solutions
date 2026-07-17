class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n=s.length();
        int diffArray[]=new int[n];
        for(int i=0;i<shifts.length;i++){
            int dir=shifts[i][2]==1?1:-1;
            diffArray[shifts[i][0]]+=dir;
            if(shifts[i][1]+1<n) diffArray[shifts[i][1]+1]-=dir;
        }
        for(int i=1;i<n;i++){
            diffArray[i]+=diffArray[i-1];
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            int orig=s.charAt(i)-'a';
            int newPos=(((diffArray[i]+orig)%26)+26)%26;
            sb.append((char)('a'+newPos));
        }
        return sb.toString();
    }
}