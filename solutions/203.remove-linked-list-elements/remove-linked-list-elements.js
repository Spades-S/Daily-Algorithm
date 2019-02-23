/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} val
 * @return {ListNode}
 */
var removeElements = function(head, val) {
    while(head !== null && head.val === val){
        head = head.next;
    }
    if(head === null) return null;
    let pre = head;
    let cur = head.next;
    while(cur !== null){
        if(cur.val === val){
            pre.next = cur.next;
        }else{
            pre = cur;
        }
        cur = cur.next;
    }
    return head;
};