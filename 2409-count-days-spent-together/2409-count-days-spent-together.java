class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] monthToDays=new int[13];
        int[] days={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for(int i=1;i<=12;i++){
            monthToDays[i]=days[i-1]+monthToDays[i-1];
        }
        int aStart=monthToDays[Integer.parseInt(arriveAlice.substring(0,2))-1]+Integer.parseInt(arriveAlice.substring(3));
        int bStart=monthToDays[Integer.parseInt(arriveBob.substring(0,2))-1]+Integer.parseInt(arriveBob.substring(3));
        int aEnd=monthToDays[Integer.parseInt(leaveAlice.substring(0,2))-1]+Integer.parseInt(leaveAlice.substring(3));
        int bEnd=monthToDays[Integer.parseInt(leaveBob.substring(0,2))-1]+Integer.parseInt(leaveBob.substring(3));
        if((bStart>aEnd)||(aStart>bEnd)){
            return 0;
        }
        int start=Math.max(aStart,bStart);
        int end=Math.min(aEnd,bEnd);
        return end-start+1;
    }
}