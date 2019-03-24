/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    if(s.length === 0) return 0;
    const map = new Map();
    let res = 0;
    let left = 0, right = 0;
    for(let i = 0; i < s.length; i++){
        if(map.has(s[i])){
            res = Math.max(res, right - left + 1);
            left = Math.max(map.get(s[i]) + 1, left);
        }
        right = i;
        map.set(s[i], i);
    }
    res = Math.max(res, right - left + 1);
    return res;
};