/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaxConsecutiveOnes = function(nums) {
    let res = 0;
    let cnt = 0;
    for(let num of nums){
        if(num === 1){
            cnt++;
        }else if(cnt != 0){
            res = Math.max(res, cnt);
            cnt = 0;
        }
    }
    res = Math.max(res, cnt);
    return res;
};