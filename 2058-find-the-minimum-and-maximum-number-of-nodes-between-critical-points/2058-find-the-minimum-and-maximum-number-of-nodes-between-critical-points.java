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
        ListNode curr = head.next;
        ListNode prev = head;
        int curr_critical_point = 1;
        int first_critical_point =-1;
        int prev_critical_point = -1;
        int res[] = new int[2];
        res[0] = Integer.MAX_VALUE;
        
        while(curr.next!= null){
            ListNode next = curr.next;
            if((curr.val > prev.val && curr.val > next.val)||
                (curr.val < prev.val && curr.val < next.val))
            {
                if(first_critical_point == -1){
                    first_critical_point = curr_critical_point;
                    prev_critical_point = curr_critical_point;
                }
                else{
                    res[0] = Math.min(res[0], curr_critical_point - prev_critical_point);
                    prev_critical_point = curr_critical_point;
                }
            }
            prev = prev.next;
            curr = curr.next;
            curr_critical_point++;
        }
        if(first_critical_point!= -1 && res[0]!= Integer.MAX_VALUE){
            res[1] = prev_critical_point - first_critical_point;
        }
        else{
            res[0]=-1;
            res[1]=-1;
        }
            return res;
    }
}