/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
    let index = m + n - 1;
    m -= 1;
    n -= 1;
    while(n >= 0 && m >= 0){
        if(nums1[m] > nums2[n]){
            nums1[index] = nums1[m];
            m--;
        }else{
            nums1[index] = nums2[n];
            n--;
        }
        index--;
    }
    while(n>=0){
        nums1[index] = nums2[n];
        index--;
        n--;
    }
    
};