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
var getMinimumDifference = function(root) {
    if(root === null) return -1; 
    let preValue = undefined;
    let res = Infinity;
    helper(root);
    return res;
    
    function helper(node){
        if(node == null) return;
        helper(node.left);
        if(preValue!== undefined && res > Math.abs(node.val - preValue)){
            res = Math.abs(node.val - preValue);
        }
        preValue = node.val;
        helper(node.right);
    }
    
};