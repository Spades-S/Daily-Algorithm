/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
    const res = [];
    helper(n, n, 0, '');
    return res;
    
    function helper(left, right, leftInStack, str){
        if(left === 0 && right === 0){
            res.push(str);
            return;
        }
        if(leftInStack === 0){
            helper(left - 1, right, leftInStack + 1, str+'(');
        }else{
            if(left !== 0){
                helper(left - 1, right, leftInStack + 1, str+'(');
            }
            helper(left, right - 1, leftInStack - 1, str+')');
        }
    }
    
};