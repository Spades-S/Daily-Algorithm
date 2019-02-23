/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var diameterOfBinaryTree = function(root) {
    if(root === null) return 0;
    let res = 0;
    helper(root);
    return res;
    
    function helper(node){
        if(node === null) return 0;
        const left = helper(node.left);
        const right = helper(node.right);
        res = Math.max(res, left + right);
        return 1 + Math.max(left, right);
    }
    
    
};