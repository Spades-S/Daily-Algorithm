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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, root, 0);
        return res;
    }
    
    public void helper(List<List<Integer>> res, TreeNode root, int deepth){
        if(root == null){
            return;
        }
        if(res.size() - 1 < deepth){
            List<Integer> list = new ArrayList<Integer>();
            list.add(root.val);
            res.add(0, list);
        }else{
            res.get(res.size() - 1 - deepth).add(root.val);
        }
        
        helper(res, root.left, deepth + 1);
        helper(res, root.right, deepth + 1);
    }
    
}