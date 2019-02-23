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
    
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    public int helper(TreeNode node, int sum){
        if(node == null) return 0;
        int res = 0;
        if(sum == node.val){
            res += 1;
        }
        return res + helper(node.left, sum - node.val) + helper(node.right, sum - node.val); 
    }
}