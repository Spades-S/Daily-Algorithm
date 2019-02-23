/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    let oldNumsLength = nums.length
    if(oldNumsLength<=1){
        return oldNumsLength
    }
    let lastNum = nums[0]
    let result = 1
    for(let i=1;i<oldNumsLength;i++){
        if(lastNum !== nums[i]){
            nums[result]= nums[i]
            result++
            lastNum = nums[i]
        }
    }
    return result
    
    
};