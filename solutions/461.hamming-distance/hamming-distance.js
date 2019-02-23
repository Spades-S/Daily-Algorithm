/**
 * @param {number} x
 * @param {number} y
 * @return {number}
 */
var hammingDistance = function(x, y) {
    let hamming = x ^ y;
    let res = 0;
    while(hamming!==0){
        res++;
        hamming &= (hamming - 1);
    }
    return res;
};