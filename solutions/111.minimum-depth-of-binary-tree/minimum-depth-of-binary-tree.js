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
var minDepth = function(root) {
    if(root === null) return 0;
    return BFSHelper([{
        node: root,
        deepth: 1
    }])
    
    function BFSHelper(nodeArr){
        while(nodeArr.length > 0){
            let {node, deepth} = nodeArr.shift();
            if(node.left === null && node.right === null) return deepth;
            if(node.left !== null) nodeArr.push({
                node: node.left, deepth: deepth + 1 
            });        
            if(node.right !== null) nodeArr.push({
                node: node.right,
                deepth: deepth + 1
            })
        }
        return 0;
    }

    
};