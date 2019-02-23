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
    public boolean res = true;
    public boolean isBalanced(TreeNode root) {
        deep(root, 0);
        return res;
    }
    public int deep(TreeNode root, int n){
        if(root == null) return n;
        int left = deep(root.left, n + 1);
        int right = deep(root.right, n + 1);
        if(left -right > 1 || left -right < -1){
            res = false;
        }
        return Math.max(left, right);
    }
}