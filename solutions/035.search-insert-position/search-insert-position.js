/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var searchInsert = function(nums, target) {
    let res = -1;
    for(let i = 0; i < nums.length; i++){
        if(nums[i] >= target){
            res = i;
            break;
        }
    }
    if(res === -1) res = nums.length;
    return res;
};