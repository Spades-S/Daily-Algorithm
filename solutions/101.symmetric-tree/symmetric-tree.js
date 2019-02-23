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
var isSymmetric = function(root) {
    if(root === null) return true;
    return helper(root.left, root.right);
    
    function helper(p, q){
        if(p === null && q === null){
            return true;
        }else if(p !== null && q !== null){
            if(p.val !== q.val) return false;
            return helper(p.left, q.right) && helper(p.right, q.left);
        }else{
            return false;
        }
    }
    
};