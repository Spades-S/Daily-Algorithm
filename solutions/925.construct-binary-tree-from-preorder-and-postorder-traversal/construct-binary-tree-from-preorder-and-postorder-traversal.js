/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {number[]} pre
 * @param {number[]} post
 * @return {TreeNode}
 */
var constructFromPrePost = function(pre, post) {
    return helper(pre, post, 0, pre.length - 1);
    
    
    
    function helper(pre, post, start, end){
        if(start > end) return null;
        const node = new TreeNode(pre.shift());
        if(pre.length > 0){
            const leftIdx = find(post, start, end, pre[0]);
            if(leftIdx !== -1){
                node.left = helper(pre, post, start, leftIdx);
                node.right = helper(pre, post, leftIdx + 1, end - 1); 
            }
        }
       
        return node;
    }
    
    function find(post, start, end, val){
        for(let i = start; i < end; i++){
            if(post[i] === val){
                return i;
            }
        }
        return -1;
    }
    
};