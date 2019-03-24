/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var deleteDuplicates = function(head) {
    if(head === null) return null;
    let pre = head;
    let cur = head.next;
    while(cur !== null){
        if(cur.val === pre.val){
            pre.next = cur.next;
            cur = cur.next;
        }else{
            pre = cur;
            cur = cur.next;
        }
    }
    return head;
    
};