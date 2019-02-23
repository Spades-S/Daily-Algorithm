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
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, 0);
    }
    
    public int helper(TreeNode node, int pos){ // -1 -> left, 0 -> root, 1 -> right;
        if(node == null) return 0;
        int res = 0;
        if(node.left == null && node.right == null && pos == -1){
            res = node.val;
        }
        return  res + helper(node.left, -1) + helper(node.right, 1);
    }
}