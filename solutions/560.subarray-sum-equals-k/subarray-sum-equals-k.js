/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var subarraySum = function(nums, k) {
    const map = new Map();
    map.set(k, 1);
    let res = 0;
    nums.reduce((acc, cur) =>{
        const sum = acc + cur;
        if(map.has(sum)){
            res += map.get(sum);
        }
        let cnt = 1;
        if(map.has(sum + k)){
            cnt += map.get(sum + k);
        }
        map.set(sum + k, cnt);
        return sum;
    }, 0);
    return res;    
};