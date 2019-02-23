/**
 * @param {number[]} nums
 * @return {string[]}
 */
var findRelativeRanks = function(nums) {
    const map = new Map();
    for(let i = 0; i < nums.length; i++){
        map.set(nums[i], i);
    }
    const res = new Array(nums.length);
    nums.sort((a,b)=> b-a);
    for(let i = 0; i < nums.length; i++){
        switch(i){
            case 0:
                res[map.get(nums[i])] = 'Gold Medal';
                break;
            case 1:
                res[map.get(nums[i])] = 'Silver Medal';
                break; 
            case 2:
                res[map.get(nums[i])] = 'Bronze Medal';
                break;
            default:
                res[map.get(nums[i])] = '' + (i + 1);
        }
    }
    return res;
};