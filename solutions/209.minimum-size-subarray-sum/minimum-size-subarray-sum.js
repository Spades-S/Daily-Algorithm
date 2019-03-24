/**
 * @param {number} s
 * @param {number[]} nums
 * @return {number}
 */
var minSubArrayLen = function(s, nums) {
    if(nums.length === 0) return 0;
    let left = 0, right = 0, sum = 0;
    let res = Number.MAX_SAFE_INTEGER;
    while(right < nums.length){
        sum += nums[right];    
        while(sum >= s){
            res = Math.min(res, right - left + 1);
            sum -= nums[left];
            left++;
        } 
        right++;
    }
    if(res === Number.MAX_SAFE_INTEGER) return 0;
    return res;
};