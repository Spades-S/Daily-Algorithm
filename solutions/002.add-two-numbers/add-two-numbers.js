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
 var addTwoNumbers = function(l1,l2){
     let temp1,temp2;
     let sum=0,carry=0;
     let head = new ListNode(0);
     
     let currentNode = head;
     temp1 = l1 ;
     temp2 = l2;
     
     
     while(temp1!==null || temp2!== null){
         if(temp1 === null){
            tempSum = temp2.val;
            temp2 = temp2.next;
         }else if(temp2 === null){
            tempSum = temp1.val;
            temp1 = temp1.next;
             
         }else{
             tempSum = temp1.val + temp2.val;
             temp1 = temp1.next;
             temp2 = temp2.next;
         }
         
         
         sum = (tempSum+carry)%10;
         carry = Math.floor((tempSum+carry)/10);
     
        //  let nextNode = new ListNode(sum);
         currentNode.next = new ListNode(sum);
         currentNode = currentNode.next;
         
     }
     if(carry !== 0){
      
         currentNode.next = new ListNode(carry);
         
     }
     return head.next;
   
     
 }
