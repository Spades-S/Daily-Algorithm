/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head1 = l1, head2 = l2;
        ListNode temp = result;
        int carry = 0;
        while(head1!=null || head2!=null){
            int sum = (head1!=null?head1.val:0)+ (head2!=null?head2.val:0)+carry ;
            temp.next = new ListNode(sum%10);
            carry = sum / 10;
            temp = temp.next;
            if(head1!=null) head1 =head1.next;
            if(head2!=null) head2 = head2.next;
        }
        if(carry != 0){
            temp.next = new ListNode(carry);
        }

        return result.next;
        
        
        
    }
}