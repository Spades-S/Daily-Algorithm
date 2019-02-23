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
    private  int nth = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(inorder, preorder, 0, inorder.length -1,  map);
    }
    
    public TreeNode helper(int[] inorder,  int[] preorder, int start, int end, HashMap<Integer, Integer> map){
        // 终止条件
        if(start > end){
            return null;
        }
        if(start == end){
            nth++;
            return new TreeNode(inorder[end]);
        }
        
        int currentValue = preorder[nth];
        TreeNode current = new TreeNode(currentValue);
        nth++;
        int index = map.get(currentValue);
        current.left = helper(inorder, preorder, start, index - 1, map);
        current.right = helper(inorder, preorder, index + 1, end, map);
        return current;
        
    }

}