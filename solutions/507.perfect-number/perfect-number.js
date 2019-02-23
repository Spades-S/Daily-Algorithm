/**
 * @param {number} num
 * @return {boolean}
 */
var checkPerfectNumber = function(num) {
    if(num <= 1) return false;
    let sum = 1;
    for(let i = 2; i <= Math.floor(Math.sqrt(num)); i++){
        if(num % i === 0){
            sum += i + num / i;
        }
    }
    if(sum === num) return true;
    return false;
};