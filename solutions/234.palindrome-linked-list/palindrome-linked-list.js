/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {boolean}
 */
var isPalindrome = function(head) {
    let preV = null;
    let cur = head;
    let curV =( cur === null ? null : new ListNode(cur.val));
    while(cur !== null){
        cur = cur.next;
        const node = (cur === null ? null : new ListNode(cur.val));
        curV.next = preV;
        preV = curV;
        curV = node;
    }
    cur = head;
    while(preV !== null){
        if(preV.val !== cur.val){
            return false;
        }
        preV = preV.next;
        cur = cur.next;
    }
    return true;
};