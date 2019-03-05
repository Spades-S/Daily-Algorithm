/**
 * @param {number[]} nums
 * @return {boolean}
 */
var find132pattern = function(nums) {
    let min = Number.MAX_SAFE_INTEGER;
    
    for(let i = 0; i < nums.length; i++){
        min = Math.min(min, nums[i]);
        if(min === nums[i]) continue;
        for(let k = i + 1; k < nums.length; k++){
            if(nums[k] > min && nums[k] < nums[i]){
                return true;
            }
        }
    }
    return false;  
};