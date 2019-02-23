/**
 * @param {string} S
 * @param {number} K
 * @return {string}
 */
var licenseKeyFormatting = function(S, K) { 
    S = S.split('-').join('').toUpperCase();
    const len = S.length;
    if(len === 0) return '';
    let start = 0;
    let res = '';
    if((len % K) === 0){
        res += S.substring(start, start + K);
        start += K;
    }else{
        res += S.substring(start, start + (len % K));
        start += (len % K);
    }
    for(let i = start; i < len; i += K){
        res += '-' + S.substring(i, i + K);
    }
    return res;
};