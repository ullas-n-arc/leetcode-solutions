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
        ArrayList<Integer> points=new ArrayList<>();
        int i=1;
        ListNode prev=head;
        ListNode cur=head.next;
        ListNode next=cur.next;
        while(next!=null){
            if(isCritical(prev.val,cur.val,next.val)){
                points.add(i);
            }
            i++;
            prev=cur;
            cur=next;
            next=next.next;
        }
        if(points.size()==0||points.size()==1) return new int[]{-1,-1};
        //max diff will be two extreme points 
        //min distance i have to traverse points
        int maxDistance=points.get(points.size()-1)-points.get(0);
        int minDistance=maxDistance;
        for(i=1;i<points.size();i++){
            int diff=points.get(i)-points.get(i-1);
            if(diff<minDistance){
                minDistance=diff;
            }
        }
        return new int[]{minDistance,maxDistance};
    }
    boolean isCritical(int prev,int cur,int next){
        if((cur>prev&&cur>next)||(cur<prev&&cur<next)){
            return true;
        }
        return false;
    }
}