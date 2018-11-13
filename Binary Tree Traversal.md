### 094 Binary Tree Inorder Traversal

#### Problem

Given a binary tree, return the inorder traversal of its nodes' values.

#### Example

```
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
```

#### Follow Up

Recursive solution is trivial, could you do it iteratively?

#### Solution

【分析】本题要求是中序遍历二叉树。
【递归】用递归的方式去中序遍历二叉树是比较简单的。

```java

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
				helper(root, list);
				return list;
    }
		public void helper(TreeNode node, List<Integer> list){
			if(node == null) return;
			helper(node.left, list);
			list.add(node.val);
			helper(node.right, list);
		}
}

```

递归的方式既简单效率又高，但是题目说了递归的方式太简单了，用迭代的方式试试。

【迭代-使用栈】思路如下：

- 从根结点开始，先将根结点压入栈，然后将其左子结点压入栈，直到当前结点左子结点为空；(1)
- 取出栈顶元素，保存该结点的值，然后将指针指向该结点的右结点；(2)
- 如果右结点为空，则执行(2), 直到栈为空；(3)
- 如果右结点不为空，重复过程(1)。 (4)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
				Stack<TreeNode> stack = new Stack<>();
				TreeNode cur = root;
				while(cur != null || !stack.empty()){
					while(cur != null){
						stack.push(cur);
						cur = cur.left;
					}
					cur = stack.pop();
					list.add(cur.val);
					cur =  cur.right;
				}
				return list;
    }
}

```

【mirror-traversal】mirror-traversal 方法利用了线索二叉树，[线索二叉树](https://en.wikipedia.org/wiki/Threaded_binary_tree#The_array_of_Inorder_traversal)是二叉树的一种变体，主要不同在于在线索二叉树中，叶子结点能够通过线索指针找到其父结点。

对于先序遍历来说，遍历顺序是左子树->根->右子树，不论是通过递归的方式还是使用栈的做法，都是为了能够在遍历完左子树后找到根结点。对于二叉树而言，如果结点上不存在指向父结点的指针，是无法做到从叶子结点回到根结点的。线索二叉树也是为了能够实现遍历完左子树之后能够找到根结点。

【构建线索二叉树】
`cur` 指针表示当前结点，初始化是指向二叉树根节点

- 如果当前结点 cur 的左孩子为空，输出当前节点值，让右孩子赋给当前结点，即 cur = cur.right。
	- 当前节点含有右子树
	- 当前节点不含右子树，此时当前节点为根结点的前驱节点，通过cur= cur.right，将指针由左子树挪到根结点
- 如果当前左孩子不为空，找到当前结点左子树的最右结点，将其称为前驱节点。我们知道在中序遍历二叉树时，必须先遍历完左子树所有结点，然后才能访问根节点。那么左子树遍历完的标志是什么呢？左子树的最右结点遍历完成。当左子树遍历完成时，下一步就是去遍历根节点，所以在中序遍历中对于根节点而言，左子树的最右结点就是根节点的前驱节点。
  - 如果前驱节点右孩子（当前结点的左子树的最右结点的右孩子）为空，将其赋为当前节点。记前驱节点为 pre， 有 pre.right = cur，并将当前节点左结点赋给当前节点，即cur = cur.left。
  - 如果前驱节点右孩子（当前结点的左子树的最右结点的右孩子）为当前结点，表明当前结点的左子树已经遍历完成，cur指针再次回到当前结点，此时可以访问当前结点。输出当前结点值，将前驱结点右孩子置为空，恢复成普通二叉树。将cur指针指向当前结点右孩子，即cur = cur.right。

``` java

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
				TreeNode cur = root, pre = null;
				while(cur != null){
					if(cur.left == null){
						list.add(cur.val);
						cur = cur.right;
					}else{
						pre = cur.left; 
						while(pre.right != null && pre.right != cur) // 这里pre.right != cur条件不可省略，当左子树遍历完成再次回到根节点时，如果不加该条件，将会进入死循环
							pre = pre.right;
						if(pre.right == null){
							pre.right = cur;
							cur = cur.left;
						}else{ // 这里 else  和 else if(pre == cur)是等价的
							list.add(cur.val);
							pre.right = null;
							cur = cur.right;
						}
					}
				}
				return list;
    }
}
```


### 144 Binary Tree Preorder Traversal

#### Problem
Given a binary tree, return the preorder traversal of its nodes' values.

#### Example
```
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
```

#### Follow up
Recursive solution is trivial, could you do it iteratively?


#### Solution
【递归】最容易的方法。
``` java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
				helper(root, list);
				return list;
    }
		public void helper(TreeNode node, List<Integer> list){
			if(node == null) return;
			list.add(node.val);
			helper(node.left, list);
			helper(node.right, list);
		}
}

```

【迭代-用栈】
- 从根结点开始，先将根结点压入栈，保存该结点的值，然后将其左子结点压入栈，保存该结点的值，直到当前结点左子结点为空；(1)
- 取出栈顶元素，然后将指针指向该结点的右结点；(2)
- 如果右结点为空，则执行(2), 直到栈为空；(3)
- 如果右结点不为空，重复过程(1)。 (4)

先序遍历和中序遍历的区别在于保存值的时机不同。先序是在入栈时保存值，中序是在从栈中吐出来时保存值。

``` java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
				Stack<TreeNode> stack = new Stack<>();
				TreeNode cur = root;
				while(cur != null || !stack.empty()){
					while(cur != null){
						stack.add(cur);
						list.add(cur.val);
						cur = cur.left;
					}
					cur = stack.pop();
					cur = cur.right;
				}
				return list;
    }
}
```

【迭代-线索树】
中序遍历和先序遍历最大的不同在于遍历顺序，是先左子树再根结点还是先根结点再左子树。我们知道在线索二叉树中，对于有左子树的根结点在遍历过程中是会被遍历两次的，第一次是在遍历其左子树之前，第二次是在其左子树遍历完成之后。对于中序遍历，要在左子树遍历完成之后再去遍历根结点，所以在List中添加根结点是在第二次遍历到根结点时。而对于先序遍历，须在遍历左子树之前去遍历根结点，所以在List中添加根结点的时机是在第一次遍历到根结点时。

``` java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> list = new ArrayList<Integer>();
			TreeNode cur = root, pre = null;
			while(cur != null){
				if(cur.left == null){
					list.add(cur.val);
					cur = cur.right;
				}else{
					pre = cur.left;
					while(pre.right != null && pre.right != cur)
						pre = pre.right;
					if(pre.right == null){
						pre.right = cur;
						list.add(cur.val);
						cur = cur.left;
					}else{
						cur= cur.right;
						pre.right = null;
					}
				}
			}
			return list;
  }
}

```


### 145 Binary Tree Postorder Traversal

#### Problem
Given a binary tree, return the postorder traversal of its nodes' values.

#### Example
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]

#### Follow up
Recursive solution is trivial, could you do it iteratively?

#### Solution
【递归】最容易的方法。
``` java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
			List<Integer> res = new ArrayList<Integer>();
			helper(root, res);
			return res;
    }
		public void helper(TreeNode node, List<Integer> list){
			if(node == null) return;
			helper(node.left, list);
			helper(node.right, list);
			list.add(node.val);
		}
}
```


【递归-用栈】
后续遍历二叉树，按照先左子树再右子树最后根结点的顺序进行。对于中序遍历，当当前结点cur不为空时(cur!=null)将其入栈，并将其左子结点赋给它(cur = cur.left)，直到当前结点为空(cur == null)。随后，立即吐出栈顶结点，并保存其值。之所以这里可以立即吐出并保存其值，是因为：对于当前结点而言，其左子树为空，由于中序遍历在左子树为空时，应该读取根结点。后续遍历和中序遍历的不同在于，当当前结点的左子树为空时，应该观察当前结点的右子树是否为空，如果为空，则吐出当前节点，保存当前结点值，如果不为空，则应该接着遍历当前结点的右子树。

【BUG-后续遍历中的无限循环】
![20181113175706.png](https://i.loli.net/2018/11/13/5beaa00ed2dfe.png)


``` java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
			List<Integer> res = new ArrayList<Integer>();
			Stack<TreeNode> stack = new Stack<TreeNode>();
			TreeNode cur = root, poped = root;
			while(cur != null || !stack.isEmpty()){
				while(cur != null){
					stack.push(cur);
					cur = cur.left;
				}
				cur = stack.peek();
				if(cur.right != null && cur.right != poped){
					cur = cur.right;
				}else{
					res.add(cur.val);
					poped = stack.pop();
					cur = null;
				}
			}
			return res;
    }
}
```

