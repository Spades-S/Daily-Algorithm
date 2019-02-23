 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode leftList = head, rightList = slow.next;
        slow.next = null;
        leftList = sortList(leftList);
        rightList = sortList(rightList);
        return merge(leftList, rightList);
        
    }
    
    public ListNode merge(ListNode left, ListNode right){
        ListNode result = new ListNode(0), current = result;
        
        while(left != null && right != null){
            if(left.val < right.val){
                current.next = new ListNode(left.val);
                current = current.next;
                left = left.next;
            }else{
                current.next = new ListNode(right.val);
                current = current.next;
                right = right.next;
            }
        }
        if(left == null){
            current.next = right;
        }else if(right ==null){
            current.next = left;
        }
        
        return result.next;
        
    }
}