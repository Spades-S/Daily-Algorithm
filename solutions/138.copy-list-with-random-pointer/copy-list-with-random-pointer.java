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
		    RandomListNode cur = head;
            while(cur != null){
                RandomListNode temp = cur.next;
                cur.next = temp.next;
                if(temp.next != null){
                    temp.next = temp.next.next;
                }
                cur = cur.next;
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
