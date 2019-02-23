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
var isBalanced = function(root) {
    let res = true;
    getHeight(root);
    return res;
    
    function getHeight(node){
        if(node === null) return 0;
        const left = getHeight(node.left);
        const right = getHeight(node.right);
        if(Math.abs(right - left) > 1){
            res = false;
        }
        return Math.max(left, right) + 1;
    }
};