/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function(candidates, target) {
    const res = [];
    helper(candidates, 0, [], 0, target);
    return res;
    
    function helper(nums, index, arr, sum, target){
        if(sum === target){
            res.push([...arr]);
            return;
        }
        if(sum > target || index >= nums.length ){
            return;
        }
        
        for(let i = index; i < nums.length; i++){
            arr.push(nums[i]);
            helper(nums, i, arr, sum + nums[i], target);
            arr.pop();
        }
    }
    
};