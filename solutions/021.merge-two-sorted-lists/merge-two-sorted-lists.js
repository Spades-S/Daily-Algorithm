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
    let tempNode = new ListNode(0)
    let result = tempNode
    while(l1!==null && l2!==null){
        if(l1.val <= l2.val){
            tempNode.next = l1
            l1 = l1.next
        }else{
            tempNode.next = l2
            l2 = l2.next
        }
        tempNode = tempNode.next
        
    }
    if(!l1){
        tempNode.next = l2
    }else{
        tempNode.next = l1
    }
    return result.next
    
};