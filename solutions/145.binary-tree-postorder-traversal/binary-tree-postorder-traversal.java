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
			TreeNode cur = root, poped = null;
			while(cur != null || !stack.isEmpty()){
				while(cur != null){
					stack.push(cur);
					cur = cur.left;
				}
				cur = stack.peek();
				if(cur.right != null && cur.right != poped){
					cur = cur.right;
				}else{
                    poped = stack.pop();
					res.add(cur.val);
					cur = null;
				}
			}
			return res;
    }
}