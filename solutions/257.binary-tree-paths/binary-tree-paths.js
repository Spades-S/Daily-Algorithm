/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {string[]}
 */
var binaryTreePaths = function(root) {
    const res = []
    if(root === null) return res;
    helper(root, '');
    return res;
    
    function helper(node, str){
        if(str === '') str = ''+node.val;
        else str += `->${node.val}`;
        if(node.left === null && node.right === null){
            res.push(str);
            return;
        }
        if(node.left !== null){
            helper(node.left, str);
        }
        if(node.right !== null){
            helper(node.right, str);
        }
     }
    
};