/**
 * @param {string} a
 * @param {string} b
 * @return {string}
 */
var addBinary = function(a, b) {
    let res = '';
    let carry = 0, i = a.length - 1, j = b.length - 1;
    while(i >= 0 || j >= 0 || carry !== 0){
        let digit1 = i >= 0 ? +a[i--] : 0;
        let digit2 = j >= 0 ? +b[j--] : 0;
        const sum = digit1 + digit2 + carry;
        res = (sum % 2) + res;
        carry = Math.floor(sum / 2);
    }
    return res;
};