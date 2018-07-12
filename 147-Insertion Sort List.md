#### Problem

Sort a linked list using insertion sort.

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

【分析】题目要求嘛，插入排序，不复杂。

【插入排序】通过构建有序序列，对于未排序数据，在已排序数据中从后向前扫描，找到相应的位置插入。

【插入排序步骤】

1. 从第一个元素开始，该元素可以认为已经被排序
2. 取出下一个元素，在已经排序的元素序列中从后向前扫描，
3. 如果该元素(已排序)大于新元素，将该元素移动到下一位置
4. 重复步骤3，直到已排序的元素小于或者等于新元素的位置
5. 将新元素插入到该位置
6. 重复步骤2-5

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
    public ListNode insertionSortList(ListNode head) {
        ListNode currentNode = head;
        ListNode result = new ListNode(0);
        ListNode sorted = result;
        while(currentNode != null){
            int currentValue = currentNode.val;
            if(sorted.val > currentValue) sorted = result;
            while(sorted.next != null && sorted.next.val<currentValue){
                sorted = sorted.next;
            }
            ListNode temp = sorted.next;
            sorted.next = new ListNode(currentValue);
            sorted.next.next = temp;
            currentNode = currentNode.next;
        }
        return result.next;
        
    }
}
```

需要注意的一点就是输入数据是链表，链表插入新元素相对而言比较简单，temp = current.next, current.next = tobesoted, tobesorted = temp; 先断开链表，再接起来。不用像数组那样，需要把大于待插入数据的元素整体向后搬一位。

上述解法里有一个很重要的优化

```java
            int currentValue = currentNode.val;
// 很重要的优化，如果当前已排序序列倒数第二位大于currentValue，需要从已排序数组头部重新开始遍历
            if(sorted.val > currentValue) sorted = result;
            while(sorted.next != null && sorted.next.val<currentValue){
                sorted = sorted.next;
            }
```

