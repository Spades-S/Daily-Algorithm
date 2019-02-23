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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root == null) return res;
        helper(root.left, ""+root.val, res);
        helper(root.right, ""+root.val, res);
        if(root.left == null && root.right == null){
            res.add(""+root.val);
        }
        return res;
    }
    
    public void helper(TreeNode node, String str, List<String> list){
        if(node == null) return;
        str += "->" + node.val;
        if(node.left == null && node.right == null){
            list.add(str);
            return;
        }
        if(node.left != null){
            helper(node.left, str, list);
        }
        if(node.right != null){
            helper(node.right, str, list);
        }
        
    }
}