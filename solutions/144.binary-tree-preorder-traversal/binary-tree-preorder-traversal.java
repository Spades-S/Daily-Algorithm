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