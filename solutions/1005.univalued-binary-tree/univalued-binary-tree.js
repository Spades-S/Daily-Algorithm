/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isUnivalTree = function(root) {
    if(root === null) return true;
    return helper(root, root.val);
    
    function helper(node, val){
        if(node === null) return true;
        if(node.val !== val) return false;
        return helper(node.left, val) && helper(node.right, val);
    }
    
};