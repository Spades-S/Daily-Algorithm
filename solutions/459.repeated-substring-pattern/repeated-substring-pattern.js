/**
 * @param {string} s
 * @return {boolean}
 */
var repeatedSubstringPattern = function(s) {
    const len = s.length;
    const longest = Math.floor(len / 2);
    for(let i = 1; i <= longest; i++){
        if((len % i) !== 0) continue;
        const subStr = s.substring(0, i);
        const arr = new Array(Math.floor(len / i));
        arr.fill(subStr);
        if(arr.join('') === s){
            return true;
        }
    }
    return false;
};