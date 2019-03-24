/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    const sum = [0];
    let res = Number.MIN_SAFE_INTEGER;
    for(let i = 1; i <= nums.length; i++){
        let temp = nums[i - 1];
        if(sum[i - 1] >= 0){
            temp += sum[i - 1];
        }
        sum.push(temp);
        res = Math.max(temp, res);
    }
    return res;
    
};