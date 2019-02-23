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
    public int getMinimumDifference(TreeNode root) {
        int res = Integer.MAX_VALUE;
        int preVal = -1;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                TreeNode node = stack.pop();
                if(preVal != -1 && res > Math.abs(node.val - preVal)){
                    res = Math.abs(node.val - preVal);
                }
                preVal = node.val;
                cur = node.right;
            }
        }
        return res;
    }
}