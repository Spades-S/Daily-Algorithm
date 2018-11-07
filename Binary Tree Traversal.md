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
* 从根结点开始，先将根结点压入栈，然后将其左子结点压入栈，直到当前结点左子结点为空；(1)
* 取出栈顶元素，保存该结点的值，然后将指针指向该结点的右结点；(2)
* 如果右结点为空，则执行(2), 直到栈为空；(3)
* 如果右结点不为空，重复过程(1)。  (4)


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
