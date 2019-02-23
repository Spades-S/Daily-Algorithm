/**
 * @param {number} n - a positive integer
 * @return {number} - a positive integer
 */
var reverseBits = function(n) {
    let res = 0;
    for(let i = 0 ; i < 32; i++){
        const bit = n & 1;
        n = n >>> 1;
        res = (res << 1) | bit;
    }
    return res >>> 0;
};