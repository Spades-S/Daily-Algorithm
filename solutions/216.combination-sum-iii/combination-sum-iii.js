/**
 * @param {number} k
 * @param {number} n
 * @return {number[][]}
 */
var combinationSum3 = function(k, n) {
    const res = [];
    helper(0, n, 1, [], 0);
    return res;
    
    function helper(nth, target, start, arr, sum){
        if(nth === k){
            if(sum === target){
                res.push([...arr]);
            }
            return;
        }
        if(start === 10) return;
        for(let i = start; i < 10; i++){
            arr.push(i);
            helper(nth + 1, target, i + 1, arr, sum + i);
            arr.pop();
        }
    }
    
};