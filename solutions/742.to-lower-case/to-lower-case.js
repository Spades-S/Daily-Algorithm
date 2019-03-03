/**
 * @param {string} str
 * @return {string}
 */
var toLowerCase = function(str) {
    let res = '';
    const min = 'A'.charCodeAt(0), max = 'Z'.charCodeAt(0);
    for(let c of str){
        const code = c.charCodeAt(0);
        if(code >= min && code <= max ){
            res += String.fromCharCode(code + 32);
        }
        else res += c;
    }
    
    return res;
};