/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        //i will find positions of all critical point
        int i=1;
        ListNode prev=head;
        ListNode cur=head.next;
        ListNode next=cur.next;
        int firstSeenPoint=0;
        int lastSeenPoint=0;
        int curSeenPoint=0;
        int maxDistance=-1;
        int minDistance=Integer.MAX_VALUE;
        while(next!=null){
            if(isCritical(prev.val,cur.val,next.val)){
                curSeenPoint=i;
                if(firstSeenPoint==0){
                    firstSeenPoint=i;
                }else{
                    minDistance=Math.min(minDistance,curSeenPoint-lastSeenPoint);
                }
                lastSeenPoint=i;
            }
            i++;
            prev=cur;
            cur=next;
            next=next.next;
        }
        if(firstSeenPoint==0||firstSeenPoint==lastSeenPoint) return new int[]{-1,-1};
        maxDistance=lastSeenPoint-firstSeenPoint;
        return new int[]{minDistance,maxDistance};
    }
    boolean isCritical(int prev,int cur,int next){
        if((cur>prev&&cur>next)||(cur<prev&&cur<next)){
            return true;
        }
        return false;
    }
}