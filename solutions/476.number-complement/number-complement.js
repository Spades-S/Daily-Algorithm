/**
 * @param {number} num
 * @return {number}
 */
var findComplement = function(num) {
    if(num === 0) return 1;
    let res = 0, mask = 1;
    for(let i = 0; i < 32 && num > 0; i++){
        if((num & 1) === 0){
            res |= mask;
        }
        mask <<= 1;
        num >>= 1
    }
    return res;
};