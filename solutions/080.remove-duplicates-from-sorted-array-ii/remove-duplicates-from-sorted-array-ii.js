/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    let index = 0;
    for(let i = 0; i < nums.length; i++){
        if(index < 2){
            nums[index++] = nums[i];
        }else{
            if(nums[i] !== nums[index - 2]){
                nums[index++] = nums[i];
            }
        }
    }
    return index;
    
};