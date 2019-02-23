/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode currentNode = head;
        ListNode result = new ListNode(0);
        ListNode sorted = result;
        while(currentNode != null){
            int currentValue = currentNode.val;
            if(sorted.val > currentValue) sorted = result;
            while(sorted.next != null && sorted.next.val<currentValue){
                sorted = sorted.next;
            }
            ListNode temp = sorted.next;
            sorted.next = new ListNode(currentValue);
            sorted.next.next = temp;
            currentNode = currentNode.next;
        }
        return result.next;
        
    }
}