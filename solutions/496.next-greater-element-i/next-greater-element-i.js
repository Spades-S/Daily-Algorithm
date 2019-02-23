/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var nextGreaterElement = function(nums1, nums2) {
    const map = new Map();
    const stack = [];
    const res = [];
    for(let num of nums2){
        while(stack.length > 0 && stack[stack.length - 1] < num){
            map.set(stack.pop(), num);
        }
        stack.push(num);
    }
    for(let i = 0; i < nums1.length; i++){
        if(map.get(nums1[i])){
            res[i] = map.get(nums1[i]);
        }else{
            res[i] = -1;
        }
    }
    return res;
};