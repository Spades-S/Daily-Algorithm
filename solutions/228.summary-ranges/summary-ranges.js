/**
 * @param {number[]} nums
 * @return {string[]}
 */
var summaryRanges = function(nums) {
    if(nums.length === 0) return [];
    const ranges = [];
    let start = 0;
    for(let i = 0; i < nums.length; i++){
        if(i > 0 && nums[i] - nums[i - 1] !== 1){
            ranges.push(generateRange(nums, start, i - 1));
            start = i;
        }
    }
    ranges.push(generateRange(nums, start, nums.length - 1));
    return ranges;
    
    
    function generateRange(nums, start, end){
        if(start === end){
            return '' + nums[start];
        }else{
            return `${nums[start]}->${nums[end]}`;
        }
    }
    
};