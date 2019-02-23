/**
 * @param {string} s
 * @return {number}
 */
var titleToNumber = function(s) {
    let res = 0;
    for(let i = 0; i < s.length; i++){
        res = res*26 + s.charCodeAt(i) - 64;
    }
    return res;
};