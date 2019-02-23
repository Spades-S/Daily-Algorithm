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