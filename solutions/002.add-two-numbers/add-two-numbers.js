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
var addTwoNumbers = function(l1, l2) {
    let cur1 = l1, cur2 = l2, carry = 0;
    let res = new ListNode(1), temp = res;
    while(cur1 !== null || cur2 !== null || carry !== 0){
        const num1 = (cur1 !== null) ? cur1.val : 0;
        const num2 = (cur2 !== null) ? cur2.val : 0;
        const sum = num1 + num2 + carry;
        carry = Math.floor(sum / 10);
        temp.next = new ListNode(sum % 10);
        temp = temp.next;
        if(cur1 !== null) cur1 = cur1.next;
        if(cur2 !== null) cur2 = cur2.next;
        
    }
   
    
    return res.next;
};