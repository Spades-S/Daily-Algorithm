/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} node
 * @return {void} Do not return anything, modify node in-place instead.
 */
var deleteNode = function(node) {
    let pre = null;
    while(node.next !== null){
        node.val = node.next.val;
        pre = node;
        node = node.next;
    }
    pre.next = null;
};