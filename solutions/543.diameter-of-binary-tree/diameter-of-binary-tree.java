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
    public int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getDeepth(root);
        return res;
    }
    
    
    public int getDeepth(TreeNode node){
        if(node == null) return 0;
        int l = getDeepth(node.left);
        int r = getDeepth(node.right);
        res = Math.max(l+r, res);
        return 1 + Math.max(l, r);
    }
}