/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} headA
 * @param {ListNode} headB
 * @return {ListNode}
 */
var getIntersectionNode = function(headA, headB) {
    const lenA = getLength(headA);
    const lenB = getLength(headB);
    const long = lenA > lenB ? lenA : lenB;
    let longHead = lenA > lenB ? headA : headB;
    const short = lenA > lenB ? lenB : lenA;
    let shortHead = lenA > lenB ? headB : headA;
    const diff = long - short;
    for(let i = 0; i < diff; i++){
        longHead = longHead.next;
    }
    while(true){
        if(shortHead === longHead){
            return shortHead;
        }
        shortHead = shortHead.next;
        longHead = longHead.next;
    }
    return null;
    function getLength(head){
        let len = 0;
        while(head !== null){
            len++;
            head = head.next;
        }
        return len;
    }
};