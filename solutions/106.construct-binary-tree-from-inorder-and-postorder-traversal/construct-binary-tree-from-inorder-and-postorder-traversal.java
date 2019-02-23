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
    private int nth = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        nth = inorder.length - 1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, inorder.length - 1, map);
        
    }
    
    public TreeNode helper(int[] inorder, int[] postorder, int start, int end, HashMap<Integer, Integer> map ){
        // 截止条件
        if(start > end){
            return null;
        }
        if(start == end){
            nth--;
            return new TreeNode(inorder[start]);
        }
        
        int currentValue = postorder[nth];
        TreeNode current = new TreeNode(currentValue);
        nth--;
        int index = map.get(currentValue);
        current.right = helper(inorder, postorder, index + 1, end, map);
        current.left = helper(inorder, postorder, start, index - 1, map);
        return current;
    }
}