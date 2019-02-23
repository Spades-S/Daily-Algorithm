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
    public int maxDepth(TreeNode root) {
        int res = 0;
        return helper(root, res);
    }
    public int helper(TreeNode root, int res){
        if(root == null){
            return res;
        }
        return Math.max(helper(root.left, res + 1), helper(root.right, res + 1));
    }
}