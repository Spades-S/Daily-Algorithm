/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function(n) {
    let res = 0;
    for(let i = 0; i < 32; i++){
        const mask = n & 1;
        n = n >>> 1;
        if(mask === 1){
            res++;
        }
    }
    return res;
};