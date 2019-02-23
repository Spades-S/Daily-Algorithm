/**
 * @param {number} n
 * @return {string}
 */
var convertToTitle = function(n) {

    let res = '';
    while(n > 0){
        res = String.fromCharCode(65 + (n - 1) % 26 ) + res;
        n = parseInt((n - 1) / 26);
    }
    return res;
    
};