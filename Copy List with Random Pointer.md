### 138 Copy List with Random Pointer

#### Problem

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

#### Solution

【分析】本题是要做链表的深度拷贝。相比于一般的链表，本题有点特别，链表的每一个结点上除了指向下一个结点的指针 next 之外，还有一个 random 指针，指向链表中的任意一个节点或者是 null。深度拷贝，在复制 next 指针时，和一般链表的操作相同，在复制 random 指针时，我们需要知道原链表结点和新链表结点之间的映射关系。

【HashTable】

```java
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
			if(head == null) return null;
			RandomListNode res = new RandomListNode(head.label);
			HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
			map.put(head, res);
			RandomListNode curOld = head.next, curNew = res;
			while(curOld != null){
				curNew.next = new RandomListNode(curOld.label);
				map.put(curOld, curNew.next);
				curOld = curOld.next;
				curNew = curNew.next;
			}
			curOld = head;
			curNew = res;
			while(curOld != null){
				curNew.random = map.get(curOld.random);
				curOld = curOld.next;
				curNew = curNew.next;
			}
			return res;
    }
}
```

【空间复杂度为 O(1)】使用 HashTable 来存储原链表结点到新链表结点的映射关系，空间复杂度是 O(n)，如果题目给出空间复杂度限制，HashTabella 方法将不可用。这里的空间复杂度不包括 output 所用的空间。可以用下面 👇[这个方法](http://fisherlei.blogspot.com/2013/11/leetcode-copy-list-with-random-pointer.html)来降低空间复杂度。

- 对于原链表中的每一个结点都拷贝一个结点，并将其插入到原链表对应结点之后
- 设置新拷贝的节点的 random 指针
- 将链表分解为两个独立的链表

![20181115172259.png](https://i.loli.net/2018/11/15/5bed3af493235.png)

```java
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
			if(head == null) return null;
			copy(head);
			setRandom(head);

			// 拆分
			RandomListNode res = head.next;
			RandomListNode curOld = head;
			RandomListNode curNew = head.next;
			while(curNew.next != null){
				curOld.next = curNew.next;
				curNew.next = curNew.next.next;
				curOld = curOld.next;
				curNew = curOld.next;
			}
			return res;
    }
		public void copy(RandomListNode head){
			RandomListNode current = head;
			while(current != null){
				RandomListNode temp = new RandomListNode(current.label);
				temp.next = current.next;
				current.next = temp;
				current = temp.next;
			}
		}

		public void setRandom(RandomListNode head){
			RandomListNode current = head;
			while(current != null){
				current.next.random = current.random == null ? null : current.random.next; // 精华
				current = current.next.next;
			}
		}

}
```
