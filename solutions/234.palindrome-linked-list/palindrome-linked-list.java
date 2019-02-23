/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        // get length 
        ListNode cur = head;
        int len = 0;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        // get mid index
        int mid = (len + 1) / 2;
        cur = head;
        while(mid > 0){
            cur = cur.next;
            mid--;
        }
        // reverse palindrome part
        ListNode pre = null;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        // compare 
        cur = head;
        while(pre != null){
            if(pre.val != cur.val) return false;
            pre = pre.next;
            cur = cur.next;
        }
        return true;       
    }
}