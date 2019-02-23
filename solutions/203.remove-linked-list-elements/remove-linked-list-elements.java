/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while(head!= null && head.val == val){
            head = head.next;
        }
        if(head == null) return null;
        ListNode pre = head, cur = head.next;
        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
            }else{
                pre = pre.next;
            }
            cur = cur.next;
        }
        return head;
    }
}