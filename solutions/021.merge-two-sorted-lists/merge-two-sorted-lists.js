/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
    const res = new ListNode(1);
    let cur = res;
    let cur1 = l1, cur2 = l2;
    while(cur1 !== null && cur2 !== null){
        if(cur1.val > cur2.val){
            cur.next = cur2;
            cur2 = cur2.next;
        }else{
            cur.next = cur1;
            cur1 = cur1.next;
        }
        cur = cur.next;
    }
    if(cur2 === null) cur.next = cur1;
    if(cur1 === null) cur.next = cur2;
    return res.next;
    
};