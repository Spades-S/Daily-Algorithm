### 148

#### Problem

Sort a linked list in *O*(*n* log *n*) time using constant space complexity.

#### Example

```
Input: 4->2->1->3
Output: 1->2->3->4
```

```
Input: -1->5->3->4->0
Output: -1->0->3->4->5
```



#### Solutions

【分析】对一个链表做排序，题目的要求**时间复杂度O(nlogn)，空间复杂度为常数**。根据题目要求，可以使用归并排序。这道题，用的递归版归并排序。

【归并排序】本质是将两个已排序的序列合并成一个序列的操作。

【递归法】需要对待排序序列进行拆分，首先将其拆分为左右两个序列，然后对左右两个序列再次拆分，直到某次拆分后左右序列最长只有一个元素，此时两个序列均为已排序，可以进行归并操作。执行递归。最终得到长度为原序列一半的两个序列，此时这两个序列均已排序，可以执行归并操作，进而可以得到排序序列。

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode leftList = head, rightList = slow.next;
        slow.next = null;
        leftList = sortList(leftList);
        rightList = sortList(rightList);
        return merge(leftList, rightList);
    }
    
    public ListNode merge(ListNode left, ListNode right){
        ListNode result = new ListNode(0), current = result;
        while(left != null && right != null){
            if(left.val < right.val){
                current.next = new ListNode(left.val);
                current = current.next;
                left = left.next;
            }else{
                current.next = new ListNode(right.val);
                current = current.next;
                right = right.next;
            }
        }
        if(left == null){
            current.next = right;
        }else if(right ==null){
            current.next = left;
        }
        return result.next; 
    }
}
```





