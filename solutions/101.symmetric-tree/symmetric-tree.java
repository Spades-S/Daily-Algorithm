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
    public boolean isSymmetric(TreeNode root) {
        if(root == null ) return true;
        return isSameTree(root.left, root.right);
        
    }
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null || q == null){
            if(p == null && q == null){
                return true;
            }else{
                return false;
            }
        }else if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
    }
}