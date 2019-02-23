/**
 * @param {number} num
 * @return {string}
 */
var toHex = function(num) {
    const hexChars = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'];
    let res = '';
    res = hexChars[num & 15];
    num = num >>> 4;
    while(num !== 0){
        res = hexChars[num & 15] + res;
        num = num >>> 4;
    }
    return res;
};