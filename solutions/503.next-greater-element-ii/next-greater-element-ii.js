/**
 * @param {number[]} nums
 * @return {number[]}
 */
var nextGreaterElements = function(nums) {
    const res = [];
    const indexArr = [];
    for(let i = 0; i < nums.length; i++){
   
        let start = i + 1;
        const index = findNextGreater(nums, nums[i], start, i);
        if(index === -1){
            res.push(-1);
            indexArr.push(-1);
        }else{
            res.push(nums[index]);
            indexArr.push(index);
        }
        
    }
    return res;
    
    function findNextGreater(nums, target, start, end){
        const len = nums.length;
        start = start % len;
        while(start !== end){
            if(nums[start] > target){
                return start;
            }
            start = (start + 1) % len;
        }
        return -1;
    }
    
};