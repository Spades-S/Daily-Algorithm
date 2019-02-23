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
var reverseList = function(head) {
    let pre = null;
    let cur = head;
    while(cur !== null){
        const node = cur.next;
        cur.next = pre;
        pre = cur;
        cur = node;
    }
    return pre;
};