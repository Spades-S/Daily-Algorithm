/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {TreeNode}
 */
var convertBST = function(root) {
    var sum = 0;
    function helper(root){
        if(root === null) return null;
        helper(root.right);
        root.val += sum;
        sum = root.val;
        helper(root.left);
        return root;
    }
    return helper(root);
};