/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null) return null;
        ListNode curA = headA;
        while(curA.next != null){
            curA = curA.next;
        }
        curA.next = headA;
        
        if(headB == null || headB.next == null) {
            curA.next = null;
            return null;
        }
        ListNode slow = headB.next, fast = headB.next.next;
        while(fast != null && fast.next != null){
            if(fast == slow){
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != slow) {
            curA.next = null;
            return null; 
        }
        
        slow = headB;
        while(true){
            if(slow == fast){
                curA.next = null;
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
        }
    }
}