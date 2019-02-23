/**
 * @param {string} num1
 * @param {string} num2
 * @return {string}
 */
var addStrings = function(num1, num2) {
    let res = '';
    let carry = 0;
    let i = num1.length - 1, j = num2.length -1;
    while(i >= 0 || j >= 0  || carry !== 0){
        let digit1 = i >= 0 ? +num1[i--] : 0;
        let digit2 = j >= 0 ? +num2[j--] : 0;
        const sum = digit1 + digit2 + carry; 
        res =  (sum % 10) +res ;
        carry = parseInt(sum / 10, 10);
    }
    return res;
};