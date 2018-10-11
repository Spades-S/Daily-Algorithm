### 105 Construct Binary Tree from Preorder and Inorder Traversal

#### Problem
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

#### Example
For example, given:
```
preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
```

Return the following binary tree:
```
    3
   / \
  9  20
    /  \
   15   7
```

#### Solution
【分析】题目给了先序和中序两种遍历得到的结果，先序遍历：根-左-右，中序遍历：左-根-右，在先序遍历的结果中，始终是以根节点开头的，在中序遍历的结果中，左右节点分布在根节点两侧。

在preorder数组中，第一个元素是3，表示二叉树的根节点是 `3`，我们在inorder数组中进行查找，发现inorder[1] 的值是3，从而 inorder[1]左侧的就是左子树，inorder[1]右侧的是右子树。在找到左右子树之后，可以将inorder 拆解为 左子树部分和右子树部分，分别对其递归调用原函数。

上述过程可以总结为：

1. 确定根节点，确定左右子树
2. 分别在左右子树中递归
3. 返回根节点

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
    private  int nth = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(inorder, preorder, 0, inorder.length -1);
    }
    
    public TreeNode helper(int[] inorder,  int[] preorder, int start, int end){
        // 终止条件
        if(start > end){
            return null;
        }
        if(start == end){
            nth++;
            return new TreeNode(inorder[end]);
        }
        
        int currentValue = preorder[nth];
        TreeNode current = new TreeNode(currentValue);
        nth++;
        int index = search(inorder, start, end, currentValue);
        current.left = helper(inorder, preorder, start, index - 1);
        current.right = helper(inorder, preorder, index + 1, end);
        return current;
        
    }
    
    public int search(int[] arr,  int start, int end, int target){
        for(int i = start; i<= end; i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }
}

```

这是按照上述思路编写出的代码。可以发现其中有个search函数，这块本质上用来暴搜去找index并且需要调用多次，可以利用 `HashMap` 对其进行优化。

优化后：
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
    private  int nth = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
		// 优化部分
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(inorder, preorder, 0, inorder.length -1,  map);
    }
    
    public TreeNode helper(int[] inorder,  int[] preorder, int start, int end, HashMap<Integer, Integer> map){
        // 终止条件
        if(start > end){
            return null;
        }
        if(start == end){
            nth++;
            return new TreeNode(inorder[end]);
        }
        
        int currentValue = preorder[nth];
        TreeNode current = new TreeNode(currentValue);
        nth++;
		// 优化部分
        int index = map.get(currentValue);
        current.left = helper(inorder, preorder, start, index - 1, map);
        current.right = helper(inorder, preorder, index + 1, end, map);
        return current;
        
    }

}
```



### 106 Construct Binary Tree from Inorder and Postorder Traversal

#### Problem
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

#### Example
For example, given:
```
inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
```
Return the following binary tree:
```
    3
   / \
  9  20
    /  \
   15   7
```

#### Solution
【分析】本题和 **105** 的区别在于，一个是中序+先序，一个是中序+后序。先序遍历时，根在最前面，根之后跟着的是左子树的根；而后序遍历，根在最后面，根之前的是右子树的根。

![20181011175935.png](https://i.loli.net/2018/10/11/5bbf1f09041f9.png)

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
    private int nth = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        nth = inorder.length - 1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, inorder.length - 1, map);
        
    }
    
    public TreeNode helper(int[] inorder, int[] postorder, int start, int end, HashMap<Integer, Integer> map ){
        // 截止条件
        if(start > end){
            return null;
        }
        if(start == end){
            nth--;
            return new TreeNode(inorder[start]);
        }
        
        int currentValue = postorder[nth];
        TreeNode current = new TreeNode(currentValue);
        nth--;
        int index = map.get(currentValue);
        current.right = helper(inorder, postorder, index + 1, end, map);
        current.left = helper(inorder, postorder, start, index - 1, map);
        return current;
    }
}

```







